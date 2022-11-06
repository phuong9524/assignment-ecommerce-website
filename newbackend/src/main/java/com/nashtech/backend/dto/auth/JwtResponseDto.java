package com.nashtech.backend.dto.auth;

import lombok.Builder;
import lombok.Getter;


import java.util.List;

@Getter
@Builder
public class JwtResponseDto {

    private String token;

    private final String type = "Bearer";

    private Long id;

    private String username;

    private String email;

    private List<String> roles;

}
