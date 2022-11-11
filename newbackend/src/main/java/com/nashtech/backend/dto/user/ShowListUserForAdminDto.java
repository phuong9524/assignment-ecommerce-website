package com.nashtech.backend.dto.user;

import com.nashtech.backend.data.entities.Role;
import com.nashtech.backend.dto.AuditDto;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@SuperBuilder
@Getter
public class ShowListUserForAdminDto extends AuditDto {

    final Long id;

    final String username;

    final String email;

    final Set<Role> roles;

}
