package com.example.myproject2022.controller.impl;

import com.example.myproject2022.common.GeneralResponse;
import com.example.myproject2022.common.ResponseEntity;
import com.example.myproject2022.common.ResponseFactory;
import com.example.myproject2022.controller.AdminUserController;
import com.example.myproject2022.entity.User;
import com.example.myproject2022.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminUserControllerImpl implements AdminUserController {
    public final UserService userService;
    public final ResponseFactory responseFactory;


    @Override
    public ResponseEntity<GeneralResponse<Object>> getAllUsers() {
        return responseFactory.toSuccess(userService.getUsers());
    }

    @Override
    public ResponseEntity<GeneralResponse<Object>> saveUser(User user) {
        userService.saveUser(user);
        return responseFactory.toSuccess(null);
    }
}
