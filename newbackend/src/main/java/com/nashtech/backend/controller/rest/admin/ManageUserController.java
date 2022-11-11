package com.nashtech.backend.controller.rest.admin;

import com.nashtech.backend.data.entities.Role;
import com.nashtech.backend.dto.user.ShowListUserForAdminDto;
import com.nashtech.backend.dto.user.ShowUserDetailsForAdminDto;
import com.nashtech.backend.dto.user.UpdateInfoRequestDto;
import com.nashtech.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/user")
public class ManageUserController {

    UserService userService;

    @Autowired
    public ManageUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ShowUserDetailsForAdminDto showUserDetailsForAdmin(@RequestParam String username) {
        return userService.GetUserDetailsForAdminByUsername(username);
    }

    @GetMapping
    public List<ShowListUserForAdminDto> showListOfUser(@RequestParam int pageNumber) {
        return userService.showListUser(pageNumber);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateRoles(List<Role> role,@RequestParam  String username) {
        return userService.updateRoles(role, username);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam String username) {
        return userService.deleteUser(username);
    }


}
