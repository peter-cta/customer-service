package com.example.myproject2022.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum ResponseStatusEnum {
    SUCCESS("00", "SUCCESS", "SUCCESS"),
    BAD_REQUEST("400", "BAD_REQUEST", "BAD_REQUEST"),
    INTERNAL_SERVER_ERROR("500", "INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR"),
    APPLICATION_NOT_FOUND("200", "APPLICATION_NOT_FOUND", "APPLICATION_NOT_FOUND"),
    FORBIDDEN("403", "FORBIDDEN", "FORBIDDEN");

    private final String httpStatus;
    private final String status;
    private final String message;

    private static ResponseStatusEnum getResponse(String message) {
        for (ResponseStatusEnum e : values()) {
            if (message.equals(e.getMessage())) {
                return e;
            }
        }
        return null;
    }
}
