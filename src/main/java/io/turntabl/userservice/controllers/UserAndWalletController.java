package io.turntabl.userservice.controllers;

import io.turntabl.userservice.dto.UserDto;
import io.turntabl.userservice.frontend.response.UserAndWalletResponse;
import io.turntabl.userservice.frontend.response.UserResponse;
import io.turntabl.userservice.services.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class UserAndWalletController {

    private WalletService walletService;

    @GetMapping("/api/v1/users/and/wallets")
    public List<UserAndWalletResponse> getAllUsers(@AuthenticationPrincipal Jwt principal) {
        return walletService.getUsersAndWallets(principal.getTokenValue());
    }
}
