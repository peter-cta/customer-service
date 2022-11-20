package com.example.myproject2022.controller;

import com.example.myproject2022.common.GeneralResponse;
import com.example.myproject2022.common.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(value = "public/api/user")
public interface UserController {

    @GetMapping("/get-debt-info")
    public Response<GeneralResponse<Object>> getDebtInfo();

}
