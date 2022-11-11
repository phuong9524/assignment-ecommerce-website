package com.nashtech.backend.services.impl;

import com.nashtech.backend.constant.AccountRole;
import com.nashtech.backend.data.entities.Role;
import com.nashtech.backend.data.entities.User;
import com.nashtech.backend.data.repositories.RoleRepository;
import com.nashtech.backend.data.repositories.UserRepository;
import com.nashtech.backend.dto.user.*;
import com.nashtech.backend.exceptions.RoleNotFoundException;
import com.nashtech.backend.exceptions.UsernameNotFoundException;
import com.nashtech.backend.exceptions.WrongPasswordException;
import com.nashtech.backend.mappers.UserDetailsMapper;
import com.nashtech.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    BCryptPasswordEncoder bCryptPasswordEncoder;
    UserDetailsMapper userDetailsMapper;
    RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           UserDetailsMapper userDetailsMapper,
                           RoleRepository roleRepository) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsMapper = userDetailsMapper;
        this.roleRepository = roleRepository;
    }


    @Override
    public ShowUserDetailsForUserDto GetUserDetailsForUserByUsername(String username) {

        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("username not found");
        }
        User user = userOptional.get();
        return userDetailsMapper.mapEntityToUserDetailsDto(user);
    }

    @Override
    public ShowUserDetailsForAdminDto GetUserDetailsForAdminByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("username not found");
        }
        User user = userOptional.get();
        return userDetailsMapper.mapEntityToUserDetailsForAdminDto(user);
    }

    @Override
    public ResponseEntity<?> updateRoles(List<Role> roles, String username) {

        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("cant find username");
        }
        User user = userOptional.get();

        Set<Role> role = new HashSet<>(roles);

        user.setRoles(role);
        userRepository.save(user);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);

    }


    @Override
    public List<ShowListUserForAdminDto> showListUser(int pageNumber) {

        Pageable pageWithNumberAndSize = PageRequest.of(pageNumber, 32);

        Page<User> userPage = userRepository.findAll(pageWithNumberAndSize);

        List<User> users = userPage.getContent();

        return userDetailsMapper.mapEntityToListUserDto(users);
    }

    @Override
    public ResponseEntity<?> updateUser(UpdateInfoRequestDto updateInfoRequestDto) {

        Optional<User> userOptional = userRepository.findByUsername(updateInfoRequestDto.getUsername());

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("Username not found");
        }
        User user = userOptional.get();

        userDetailsMapper.mapUpdateForUserDtoToEntity(updateInfoRequestDto);

        userRepository.save(user);

         return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<?> deleteUser(String username) {

        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("username not found");
        }
        User user = userOptional.get();

        userRepository.deleteById(user.getId());

        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<?> changePassword(ChangePasswordRequestDto changePasswordRequestDto) {

        Optional<User> userOptional = userRepository.findByUsername(changePasswordRequestDto.getUsername());
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("cant find username");
        }
        User user = userOptional.get();

        if (!bCryptPasswordEncoder.matches(changePasswordRequestDto.getCurrentPassword(), user.getPassword())) {
           throw new WrongPasswordException("Wrong password");
        }
        String newPassword = passwordEncoder.encode(changePasswordRequestDto.getNewPassword());
        user.setPassword(newPassword);

        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
