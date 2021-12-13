package io.turntabl.userservice.frontend.response;

import io.turntabl.userservice.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserAndWalletResponse {

    private UserDto userDto;
    private List<WalletResponse> walletResponseList;


}
