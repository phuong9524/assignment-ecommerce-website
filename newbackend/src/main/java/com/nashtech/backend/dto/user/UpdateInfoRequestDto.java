package com.nashtech.backend.dto.user;

import lombok.Getter;

@Getter
public class UpdateInfoRequestDto {

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private Integer telephone;

}
