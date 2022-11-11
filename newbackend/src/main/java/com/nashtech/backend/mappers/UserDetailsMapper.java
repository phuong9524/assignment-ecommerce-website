package com.nashtech.backend.mappers;

import com.nashtech.backend.data.entities.User;
import com.nashtech.backend.dto.user.ShowListUserForAdminDto;
import com.nashtech.backend.dto.user.ShowUserDetailsForAdminDto;
import com.nashtech.backend.dto.user.ShowUserDetailsForUserDto;
import com.nashtech.backend.dto.user.UpdateInfoRequestDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDetailsMapper {

    public ShowUserDetailsForUserDto mapEntityToUserDetailsDto(User user) {
        return ShowUserDetailsForUserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .telephone(user.getTelephone())
                .build();
    }

    public ShowUserDetailsForAdminDto mapEntityToUserDetailsForAdminDto(User user) {
        return ShowUserDetailsForAdminDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .roles(user.getRoles())
                .telephone(user.getTelephone())
                .build();
    }

    public List<ShowListUserForAdminDto> mapEntityToListUserDto(List<User> user) {
        return user.stream().map(userObject -> ShowListUserForAdminDto.builder()
                .id(userObject.getId())
                .email(userObject.getEmail())
                .username(userObject.getUsername())
                .roles(userObject.getRoles())
                .creationDate(userObject.getCreationDate())
                .lastModifiedDate(userObject.getModifiedDate())
                .build()).collect(Collectors.toList());
    }

    public User mapUpdateForUserDtoToEntity(UpdateInfoRequestDto updateInfoRequestDto) {
        return User.builder()
                .username(updateInfoRequestDto.getUsername())
                .email(updateInfoRequestDto.getEmail())
                .telephone(updateInfoRequestDto.getTelephone())
                .lastName(updateInfoRequestDto.getLastName())
                .firstName(updateInfoRequestDto.getFirstName())
                .build();
    }

}
