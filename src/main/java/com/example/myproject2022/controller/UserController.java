package com.example.myproject2022.controller;

import com.example.myproject2022.common.GeneralResponse;
import com.example.myproject2022.common.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(value = "/auth")
public interface UserController {

    @GetMapping(value = "/users")
    public ResponseEntity<GeneralResponse<Object>> getAllUsers();

}
