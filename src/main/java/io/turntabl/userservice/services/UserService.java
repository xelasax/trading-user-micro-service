package io.turntabl.userservice.services;

import io.turntabl.userservice.dto.OrderValidationDto;
import io.turntabl.userservice.dto.UserDto;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;

public interface UserService {
    UserDto updateUser(UserDto fromUserRequest);

    UserDto getUser(Jwt principal);

    List<UserDto> getAllUsers();
}
