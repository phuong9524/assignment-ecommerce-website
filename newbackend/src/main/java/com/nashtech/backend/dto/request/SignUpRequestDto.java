package com.nashtech.backend.dto.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
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

    private Set<String> role;
}

