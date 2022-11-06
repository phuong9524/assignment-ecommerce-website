package com.nashtech.backend.services.impl;

import com.nashtech.backend.constant.AccountRole;
import com.nashtech.backend.data.entities.Role;
import com.nashtech.backend.data.entities.User;
import com.nashtech.backend.data.repositories.RoleRepository;
import com.nashtech.backend.data.repositories.UserRepository;
import com.nashtech.backend.dto.auth.LoginRequestDto;
import com.nashtech.backend.dto.auth.SignUpRequestDto;
import com.nashtech.backend.dto.auth.JwtResponseDto;
import com.nashtech.backend.dto.auth.MessageResponseDto;
import com.nashtech.backend.security.JwtUtils;
import com.nashtech.backend.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {

    AuthenticationManager authenticationManager;
    UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;
    JwtUtils jwtUtils;

    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder,
            JwtUtils jwtUtils) {

        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }
    @Override
    public ResponseEntity<?> authenticateUser(LoginRequestDto loginRequestDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getUsername(),
                        loginRequestDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                JwtResponseDto.builder()
                        .token(jwt)
                        .id(userDetails.getId())
                        .username(userDetails.getUsername())
                        .email(userDetails.getEmail())
                        .roles(roles)
                        .build()
        );
    }

    @Override
    public ResponseEntity<?> registerUser(SignUpRequestDto signupRequestDto) {
        if (userRepository.existsByUsername(signupRequestDto.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponseDto("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signupRequestDto.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponseDto("Error: Email is already in use!"));

        }

        User user = User.builder()
                .firstName(signupRequestDto.getFirstname())
                .lastName(signupRequestDto.getLastName())
                .username(signupRequestDto.getUsername())
                .email(signupRequestDto.getEmail())
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                .telephone(signupRequestDto.getTelephone())
                .build();
//                new User(signupRequestDto.getUsername(),
//                signupRequestDto.getEmail(),
//                passwordEncoder.encode(signupRequestDto.getPassword()));
//

        userRepository.save(user);

        return ResponseEntity.ok(HttpStatus.CREATED);

    }
}
