package io.turntabl.userservice.services;

import io.turntabl.userservice.dto.OrderValidationDto;
import io.turntabl.userservice.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto updateUser(UserDto fromUserRequest);

    UserDto getUser(String userId);

    List<UserDto> getAllUsers();

    OrderValidationDto validateBuyOrder(OrderValidationDto fromRequest);
}
