package com.nashtech.backend.dto.auth;

import lombok.Builder;
import lombok.Getter;
import javax.validation.constraints.NotBlank;


@Getter
public class SignUpRequestDto {

    @NotBlank
    private String username;

    @NotBlank
    private String email;

    private String password;

}

