package io.turntabl.userservice.controllers;

import io.turntabl.userservice.dto.OrderValidationDto;
import io.turntabl.userservice.dto.UserDto;
import io.turntabl.userservice.frontend.request.OrderValidationRequest;
import io.turntabl.userservice.frontend.request.UserRequest;
import io.turntabl.userservice.frontend.response.OrderValidationResponse;
import io.turntabl.userservice.frontend.response.UserResponse;
import io.turntabl.userservice.services.UserService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/v1/user")
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        UserDto userDto = userService.updateUser(UserDto.fromUserRequest(userRequest));
        return UserResponse.fromDTO(userDto);
    }


    @GetMapping("/api/v1/user/{userId}")
    public UserResponse getUser(@PathVariable String userId) {
        UserDto userDto = userService.getUser(userId);
        return UserResponse.fromDTO(userDto);
    }

    @GetMapping("/api/v1/user")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers().stream().map(UserResponse::fromDTO).collect(Collectors.toList());
    }

    @PostMapping("/api/v1/user/validate/buy")
    public OrderValidationResponse validateOrderRequest(@RequestBody OrderValidationRequest orderValidationRequest) {
        OrderValidationDto orderValidationDto =  userService.validateBuyOrder(OrderValidationDto.fromRequest(orderValidationRequest));

        return OrderValidationResponse.fromDTO(orderValidationDto);
    }
}
