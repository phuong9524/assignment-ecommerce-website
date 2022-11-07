package com.nashtech.backend.dto.auth;

import lombok.Getter;

import javax.validation.constraints.NotBlank;


@Getter
public class LoginRequestDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}

