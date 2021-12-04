package io.turntabl.userservice.dto;

import io.turntabl.userservice.entities.PortfolioItem;
import io.turntabl.userservice.entities.UserEntity;
import io.turntabl.userservice.frontend.request.UserRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserDto implements Serializable {
    private static final long serialVersionUID = 42L;

    private String id;
    private String email;
    private String fullName;
    private String status;
    private String authToken;
    private double balance;
    private List<PortfolioItem> portfolio;

    public static UserDto fromUserRequest(UserRequest userRequest) {
        UserDto userDto = new UserDto();
        userDto.id = userRequest.getId();
        userDto.email = userRequest.getEmail();
        userDto.fullName = userRequest.getFullName();
        userDto.authToken = userRequest.getAuthToken();
        return userDto;
    }

    public static UserDto fromEntity(UserEntity save) {
        UserDto userDto = new UserDto();
        userDto.id = save.getId();
        userDto.email = save.getEmail();
        userDto.fullName = save.getFullName();
        userDto.status = save.getStatus();
        userDto.balance = save.getBalance();
        userDto.portfolio = save.getPortfolio();
        return userDto;
    }
}
