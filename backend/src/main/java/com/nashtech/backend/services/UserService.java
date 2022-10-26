package com.nashtech.backend.services;

import com.nashtech.backend.data.entities.User;

import java.util.Optional;

public interface UserService {

    User findByEmail(String email);

    User findByUsername(String username);

}
