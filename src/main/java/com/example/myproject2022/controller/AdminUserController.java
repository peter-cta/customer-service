package com.example.myproject2022.controller;

import com.example.myproject2022.common.GeneralResponse;
import com.example.myproject2022.common.Response;
import com.example.myproject2022.dto.RoleRequestDTO;
import com.example.myproject2022.dto.UserRequestDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "/private/api/admin/user")
public interface AdminUserController {
    @GetMapping(value = "/get-all")
    public Response<GeneralResponse<Object>> getAllUsers();

    @PostMapping(value = "/add")
    public Response<GeneralResponse<Object>> saveUser(@Valid @RequestBody UserRequestDTO user);

    @PostMapping(value = "/add-role")
    public Response<GeneralResponse<Object>> saveRole(@RequestBody RoleRequestDTO user);
}
