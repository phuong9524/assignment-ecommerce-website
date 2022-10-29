package com.nashtech.backend.services;

import com.nashtech.backend.dto.request.LoginRequestDto;
import com.nashtech.backend.dto.request.SignupRequestDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<?> authenticateUser(LoginRequestDto loginRequestDto);

    ResponseEntity<?> registerUser(SignupRequestDto signupRequestDto);


}
