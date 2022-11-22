package com.example.myproject2022.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class GlobalExceptionHandle {
      @ExceptionHandler(value = {BusinessException.class})
      public ResponseEntity<Object> handleBusinessException(BusinessException e){
            ApiException apiException = new ApiException(
                    e.getMessage(),
                    e,
                    HttpStatus.BAD_REQUEST,
                    ZonedDateTime.now(ZoneId.of("Z"))
            );
            return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
      }
}
