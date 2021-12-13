package io.turntabl.userservice.services.impl;

import io.turntabl.userservice.dto.UserDto;
import io.turntabl.userservice.feignclients.OrderFeignClient;
import io.turntabl.userservice.frontend.response.UserAndWalletResponse;
import io.turntabl.userservice.frontend.response.WalletResponse;
import io.turntabl.userservice.repository.UserRepository;
import io.turntabl.userservice.services.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WalletServiceImpl implements WalletService
{
    private final OrderFeignClient orderFeignClient;
    private final UserRepository userRepository;

//    @Override
//    public List<WalletResponse> getAllWallets(String token) {
//        return orderFeignClient.wallets(token);
//    }

    @Override
    public List<UserAndWalletResponse> getUsersAndWallets(String token) {
        List<UserDto> users = userRepository.findAll().stream()
                .map(UserDto::fromEntity).collect(Collectors.toList());

        List<WalletResponse> allWallets = orderFeignClient.wallets("Bearer "+ token);

        return users.stream().map(user -> {
            List<WalletResponse> wallets = allWallets.stream()
                    .filter(walletResponse -> walletResponse.getUserId().equals(user.getId()))
                    .collect(Collectors.toList());
            return new UserAndWalletResponse(user, wallets);
        }).collect(Collectors.toList());
    }
}
