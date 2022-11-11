package com.nashtech.backend.dto.user;

import com.nashtech.backend.data.entities.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Builder
@Getter
public class ShowUserDetailsForUserDto {

    final Long id;

    final String username;

    final String email;

    final String lastName;

    final String firstName;

    final Integer telephone;
}
