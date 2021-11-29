package io.turntabl.userservice.services.impl;

import io.turntabl.userservice.dto.OrderValidationDto;
import io.turntabl.userservice.dto.UserDto;
import io.turntabl.userservice.entities.UserEntity;
import io.turntabl.userservice.exceptions.UserNotFoundException;
import io.turntabl.userservice.repository.UserRepository;
import io.turntabl.userservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto updateUser(UserDto userDto) {
//        Optional<UserEntity> userEntity = userRepository.findById(userDto.getId());
        UserEntity userEntity = userRepository.findById(userDto.getId()).orElse(new UserEntity());
        userEntity.setId(userDto.getId());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setFullName(userDto.getFullName());

        if (userEntity.getStatus() == null) userEntity.setStatus("active");

        UserEntity save = userRepository.save(userEntity);
        return UserDto.fromEntity(save);
    }

    @Override
    public UserDto getUser(String userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with id " + userId + " does not exist"));
        return UserDto.fromEntity(userEntity);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public OrderValidationDto validateBuyOrder(OrderValidationDto fromRequest) {
        return null;
    }
}
