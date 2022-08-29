package com.example.myproject2022.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum ResponseStatusEnum {
    SUCCESS("00","SUCCESS"),
    BAD_REQUEST("400","BAD_REQUEST"),
    INTERNAL_SERVER_ERROR("500","INTERNAL_SERVER_ERROR"),
    APPLICATION_NOT_FOUND("APPLICATION_NOT_FOUND","APPLICATION_NOT_FOUND"),
    FORBIDDEN("403","FORBIDDEN")
    ;

    private final String code;
    private final String message;

    private static ResponseStatusEnum getResponse(String message) {
        for (ResponseStatusEnum e: values()) {
            if(message.equals(e.getMessage())){
                return e;
            }
        }
        return null;
    }
}
