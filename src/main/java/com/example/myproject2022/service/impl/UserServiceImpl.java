package com.example.myproject2022.service.impl;

import com.example.myproject2022.dto.RoleRequestDTO;
import com.example.myproject2022.dto.UserRequestDTO;
import com.example.myproject2022.entity.RolesEntity;
import com.example.myproject2022.entity.UsersEntity;
import com.example.myproject2022.entity.UsersRoleEntity;
import com.example.myproject2022.repository.RoleRepository;
import com.example.myproject2022.repository.UserRepository;
import com.example.myproject2022.repository.UserRolesRepository;
import com.example.myproject2022.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
//public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserRolesRepository userRolesRepository;

    private final PasswordEncoder passwordEncoder;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user = userRepository.findByUsername(username);
//        if(user == null){
//            log.error("User not found in database");
//            throw new UsernameNotFoundException("User not found in the db");
//        }else {
//            log.info("USer found in the db : {}", username);
//        }
//        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(user.getRole()));
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
//    }


    @Override
    public void saveUser(UserRequestDTO request) {
        UsersEntity user = UsersEntity.builder()
                .name(request.getName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole()).build();
        userRepository.save(user);
    }

    @Override
    public void saveRole(RoleRequestDTO request) {
        RolesEntity role = RolesEntity.builder().name(request.getName()).build();
        roleRepository.save(role);
    }

    @Override
    public List<UsersEntity> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addRolesToUser(String username, String role) {
        UsersEntity user = userRepository.findByUsername(username);
        RolesEntity roleEntity = roleRepository.findByName(role);
        UsersRoleEntity userRoles = UsersRoleEntity.builder()
                .userId(user.getId())
                .roleId(roleEntity.getId()).build();
        userRolesRepository.save(userRoles);
    }
}
