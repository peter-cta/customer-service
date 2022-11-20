package com.example.myproject2022.controller.impl;

import com.example.myproject2022.common.GeneralResponse;
import com.example.myproject2022.common.Response;
import com.example.myproject2022.common.ResponseFactory;
import com.example.myproject2022.controller.UserController;
import com.example.myproject2022.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final ResponseFactory responseFactory;
    private final UserService userService;
    @Override
    public Response<GeneralResponse<Object>> getDebtInfo() {
        userService.getDebtInfo();
        return responseFactory.toSuccess(null);
    }
}
