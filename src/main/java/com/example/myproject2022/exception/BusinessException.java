package com.example.myproject2022.exception;

import com.example.myproject2022.constant.ResponseStatusEnum;
import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {
    private HttpStatus httpStatus;
    private String code;
    private String message;
    private String displayMessage;

    public BusinessException(){
        this.httpStatus = HttpStatus.OK;
    }

    public BusinessException(ResponseStatusEnum responseStatusEnum){
        this();
        this.code = responseStatusEnum.getCode();
        this.message = responseStatusEnum.getMessage();
        this.displayMessage = responseStatusEnum.getMessage();
    }
}
