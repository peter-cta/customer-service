package com.example.myproject2022.service;

import com.example.myproject2022.dto.RoleRequestDTO;
import com.example.myproject2022.dto.UserRequestDTO;
import com.example.myproject2022.entity.UsersEntity;

import java.util.List;

public interface UserService {

    void saveUser(UserRequestDTO user);

    void saveRole(RoleRequestDTO role);

    List<UsersEntity> getUsers();

    void addRolesToUser(String username, String role);

    void getDebtInfo();

}
