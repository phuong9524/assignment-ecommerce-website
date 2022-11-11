package com.nashtech.backend.dto.user;

import lombok.Getter;

@Getter
public class ChangePasswordRequestDto {

    private String username;

    private String currentPassword;

    private String newPassword;

}
