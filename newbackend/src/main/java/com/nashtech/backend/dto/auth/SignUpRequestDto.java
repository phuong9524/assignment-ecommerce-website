package com.nashtech.backend.dto.auth;

import lombok.Builder;
import lombok.Getter;
import javax.validation.constraints.NotBlank;


@Getter
@Builder
public class SignUpRequestDto {

    private String lastName;

    private String firstname;

    @NotBlank
    private String username;

    @NotBlank
    private String email;

    private String password;

    private Integer telephone;

}

