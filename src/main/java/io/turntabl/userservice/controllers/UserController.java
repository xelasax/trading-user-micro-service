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
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/v1/user")
    public UserResponse createUser(@AuthenticationPrincipal Jwt principal) {
        UserDto userDto = userService.updateUser(
                UserDto.fromUserRequest(
                        new UserRequest(
                                principal.getSubject(),
                                principal.getClaims().get("email").toString(),
                                principal.getClaims().get("name").toString(),
                                principal.getTokenValue()
                        )
                )
        );

        return UserResponse.fromDTO(userDto);
    }


    @GetMapping("/api/v1/user")
    public UserResponse getUser(@AuthenticationPrincipal Jwt principal) {
        UserDto userDto = userService.getUser(principal.getSubject());
        return UserResponse.fromDTO(userDto);
    }

    @GetMapping("/api/v1/user/all")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

}
