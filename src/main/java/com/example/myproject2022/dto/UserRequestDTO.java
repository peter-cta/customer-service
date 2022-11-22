package com.example.myproject2022.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    @NotBlank(message = "Truong name khong hop le")
    private String name;

//    @NotNull(message = "Truong username khong hop le")
    private String username;

//    @NotNull(message = "Truong password khong hop le")
    private String password;

//    @NotNull(message = "Truong role khong hop le")
    private String role;

}
