package io.turntabl.userservice.frontend.response;

import io.turntabl.userservice.dto.UserDto;
import io.turntabl.userservice.entities.PortfolioItem;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
public class UserResponse {
    private String id;
    private String email;
    private String fullName;
    private String status;
    private double balance;
    private List<PortfolioItem> portfolio;

    public static UserResponse fromDTO(UserDto userDto) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(userDto,userResponse);
        return userResponse;
    }
}
