package com.example.myproject2022.service.impl;


import com.example.myproject2022.entity.Role;
import com.example.myproject2022.entity.User;
import com.example.myproject2022.entity.UserRole;
import com.example.myproject2022.repository.RoleRepository;
import com.example.myproject2022.repository.UserRepository;
import com.example.myproject2022.repository.UserRolesRepository;
import com.example.myproject2022.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserRolesRepository userRolesRepository;


    @Override
    public void saveUser(User user) {
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
