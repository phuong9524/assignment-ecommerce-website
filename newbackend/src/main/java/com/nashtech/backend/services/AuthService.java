package com.nashtech.backend.services;

import com.nashtech.backend.dto.request.LoginRequestDto;
import com.nashtech.backend.dto.request.SignUpRequestDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<?> authenticateUser(LoginRequestDto loginRequestDto);

    ResponseEntity<?> registerUser(SignUpRequestDto signupRequestDto);


}

