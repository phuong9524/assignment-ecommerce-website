package com.nashtech.backend.dto.auth;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
public class LoginRequestDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}

