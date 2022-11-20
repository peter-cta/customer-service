package com.example.myproject2022.service.impl;

import com.example.myproject2022.dto.RoleRequestDTO;
import com.example.myproject2022.dto.UserRequestDTO;
import com.example.myproject2022.entity.*;
import com.example.myproject2022.repository.*;
import com.example.myproject2022.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserRolesRepository userRolesRepository;

    private final PasswordEncoder passwordEncoder;

    private final DebtRemindInfo2Repository debtRemindInfo2Repository;

    private final DebtRemindInfoRepository debtRemindInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity user = userRepository.findByUsername(username);
        if(user == null){
            log.error("User not found in database");
            throw new UsernameNotFoundException("User not found in the db");
        }else {
            log.info("USer found in the db : {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }


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

    @Override
    public void getDebtInfo() {
        log.info("waiting");
    }
}
