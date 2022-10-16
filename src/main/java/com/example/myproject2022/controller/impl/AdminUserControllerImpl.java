package com.example.myproject2022.controller.impl;

import com.example.myproject2022.common.GeneralResponse;
import com.example.myproject2022.common.Response;
import com.example.myproject2022.common.ResponseFactory;
import com.example.myproject2022.controller.AdminUserController;
import com.example.myproject2022.dto.RoleRequestDTO;
import com.example.myproject2022.dto.UserRequestDTO;
import com.example.myproject2022.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminUserControllerImpl implements AdminUserController {
    public final UserService userService;
    public final ResponseFactory responseFactory;


    @Override
    public Response<GeneralResponse<Object>> getAllUsers() {
        return responseFactory.toSuccess(userService.getUsers());
    }

    @Override
    public Response<GeneralResponse<Object>> saveUser(UserRequestDTO request) {
        userService.saveUser(request);
        return responseFactory.toSuccess(null);
    }

    @Override
    public Response<GeneralResponse<Object>> saveRole(RoleRequestDTO request) {
        userService.saveRole(request);
        return responseFactory.toSuccess(null);
    }
}
