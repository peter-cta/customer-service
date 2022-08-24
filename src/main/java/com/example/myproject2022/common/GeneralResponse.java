package com.example.myproject2022.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class GeneralResponse<T> {

    private String code;

    private String message;

    private T data;
}
