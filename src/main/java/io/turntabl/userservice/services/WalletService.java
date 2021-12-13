package io.turntabl.userservice.services;

import io.turntabl.userservice.dto.UserDto;
import io.turntabl.userservice.frontend.response.UserAndWalletResponse;
import io.turntabl.userservice.frontend.response.WalletResponse;

import java.util.List;

public interface WalletService {
//    List<WalletResponse> getAllWallets();

    List<UserAndWalletResponse> getUsersAndWallets(String token);
}

