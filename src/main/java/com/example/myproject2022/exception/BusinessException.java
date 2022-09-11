package com.example.myproject2022.exception;

import com.example.myproject2022.constant.ResponseStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@AllArgsConstructor
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private String status;
    private String message;
    private String displayMessage;
}
