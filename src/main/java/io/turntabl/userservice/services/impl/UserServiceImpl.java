package io.turntabl.userservice.services.impl;

import io.turntabl.userservice.dto.OrderValidationDto;
import io.turntabl.userservice.dto.UserDto;
import io.turntabl.userservice.entities.UserEntity;
import io.turntabl.userservice.exceptions.UserNotFoundException;
import io.turntabl.userservice.feignclients.OrderFeignClient;
import io.turntabl.userservice.frontend.response.WalletInformation;
import io.turntabl.userservice.repository.UserRepository;
import io.turntabl.userservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final OrderFeignClient orderFeignClient;

    @Override
    public UserDto  updateUser(UserDto userDto) {
//        Optional<UserEntity> userEntity = userRepository.findById(userDto.getId());
        UserEntity userEntity = userRepository.findById(userDto.getId()).orElse(new UserEntity());
        userEntity.setId(userDto.getId());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setFullName(userDto.getFullName());

        if (userEntity.getStatus() == null) userEntity.setStatus("active");
        UserEntity userInformation = userRepository.save(userEntity);

        // CREATE WALLET IF IT DOES NOT EXIST OR GET EXISTING USER WALLET
        WalletInformation walletInformation = orderFeignClient.walletInformation("Bearer "+ userDto.getAuthToken());
        userInformation.setBalance(walletInformation.getBalance());
        userInformation.setPortfolio(walletInformation.getPortfolios());

        return UserDto.fromEntity(userInformation);
    }

    @Override
    public UserDto getUser(Jwt principal) {
        UserEntity userEntity = userRepository.findById(principal.getSubject()).orElseThrow(() -> new UserNotFoundException("User with id " + principal.getSubject() + " does not exist"));

        // CREATE WALLET IF IT DOES NOT EXIST OR GET EXISTING USER WALLET
        WalletInformation walletInformation = orderFeignClient.walletInformation("Bearer "+ principal.getTokenValue());
        userEntity.setBalance(walletInformation.getBalance());
        userEntity.setPortfolio(walletInformation.getPortfolios());

        return UserDto.fromEntity(userEntity);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserDto::fromEntity).collect(Collectors.toList());
//        return userRepository.findAll().stream().map()
    }
}
