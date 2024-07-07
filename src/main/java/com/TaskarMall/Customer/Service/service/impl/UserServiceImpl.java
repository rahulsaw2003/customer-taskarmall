package com.TaskarMall.Customer.Service.service.impl;

import com.TaskarMall.Customer.Service.dto.UserDto;
import com.TaskarMall.Customer.Service.entity.User;
import com.TaskarMall.Customer.Service.exception.ResourceNotFoundException;
import com.TaskarMall.Customer.Service.mapper.UserMapper;
import com.TaskarMall.Customer.Service.repository.UserRepository;
import com.TaskarMall.Customer.Service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser((userDto));
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
       User thisUser = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User does not exist in the database with the given id: " + userId));
        return UserMapper.mapToUserDto(thisUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUserDto) {
        User thisUser = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("The given user might not exist in database, first create it and then update!"));
        thisUser.setFirstName(updatedUserDto.getFirstName());
        thisUser.setLastName(updatedUserDto.getLastName());
        thisUser.setMobileNumber(updatedUserDto.getMobileNumber());
        thisUser.setEmail(updatedUserDto.getEmail());

        User updatedUser = userRepository.save(thisUser);
        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User thisUser = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("The given user does not exist in database"));
        userRepository.deleteById(userId);
    }


}
