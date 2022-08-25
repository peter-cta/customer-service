package com.example.myproject2022.controller;

import com.example.myproject2022.common.GeneralResponse;
import com.example.myproject2022.common.ResponseEntity;
import com.example.myproject2022.entity.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/admin")
public interface AdminUserController {
    @GetMapping(value = "/user/get-all")
    public ResponseEntity<GeneralResponse<Object>> getAllUsers();

    @PostMapping(value = "/user/add")
    public ResponseEntity<GeneralResponse<Object>> saveUser(@RequestBody User user);
}
