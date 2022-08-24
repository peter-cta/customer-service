package com.example.myproject2022.service;

import com.example.myproject2022.entity.Role;
import com.example.myproject2022.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void saveRole(Role role);

    List<User> getUsers();

    void addRolesToUser(String username, String role);

}
