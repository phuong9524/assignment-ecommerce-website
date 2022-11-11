package com.nashtech.backend.services;

import com.nashtech.backend.data.entities.Role;
import com.nashtech.backend.dto.user.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ShowUserDetailsForUserDto GetUserDetailsForUserByUsername(String username);

    ShowUserDetailsForAdminDto GetUserDetailsForAdminByUsername(String name);

    ResponseEntity<?> updateRoles(List<Role> role, String username);

    List<ShowListUserForAdminDto> showListUser(int pageNumber);

    ResponseEntity<?> updateUser(UpdateInfoRequestDto updateInfoRequestDto);

    ResponseEntity<?> deleteUser(String username);

    ResponseEntity<?> changePassword(ChangePasswordRequestDto changePasswordRequestDto);
}
