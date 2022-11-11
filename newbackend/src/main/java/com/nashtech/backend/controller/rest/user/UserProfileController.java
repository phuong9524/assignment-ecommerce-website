package com.nashtech.backend.controller.rest.user;

import com.nashtech.backend.dto.user.ChangePasswordRequestDto;
import com.nashtech.backend.dto.user.ShowUserDetailsForUserDto;
import com.nashtech.backend.dto.user.UpdateInfoRequestDto;
import com.nashtech.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/profile")
public class UserProfileController {

    UserService userService;

    @Autowired
    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ShowUserDetailsForUserDto ShowUserDetailsForUser(@RequestParam String username) {
        return userService.GetUserDetailsForUserByUsername(username);
    }

    @PutMapping
    public ResponseEntity<?> updateDetails(@RequestBody UpdateInfoRequestDto updateInfoRequestDto) {
        return userService.updateUser(updateInfoRequestDto);
    }

    @PutMapping("/password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequestDto changePasswordRequestDto) {
        return userService.changePassword(changePasswordRequestDto);
    }




}
