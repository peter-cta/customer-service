package com.example.myproject2022.service.impl;


import com.example.myproject2022.constant.ResponseStatusEnum;
import com.example.myproject2022.entity.Role;
import com.example.myproject2022.entity.User;
import com.example.myproject2022.entity.UserRole;
import com.example.myproject2022.exception.BusinessException;
import com.example.myproject2022.exception.MissingHeaderInfoException;
import com.example.myproject2022.repository.RoleRepository;
import com.example.myproject2022.repository.UserRepository;
import com.example.myproject2022.repository.UserRolesRepository;
import com.example.myproject2022.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserRolesRepository userRolesRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            log.error("User not found in database");
            throw new UsernameNotFoundException("User not found in the db");
        }else {
            log.info("USer found in the db : {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }


    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addRolesToUser(String username, String role) {
        User user = userRepository.findByUsername(username);
        Role roleEntity = roleRepository.findByName(role);
        UserRole userRoles = UserRole.builder()
                .userId(user.getId())
                .roleId(roleEntity.getId()).build();
        userRolesRepository.save(userRoles);
    }
}
