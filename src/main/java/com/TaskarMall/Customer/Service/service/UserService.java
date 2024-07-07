package com.TaskarMall.Customer.Service.service;

import com.TaskarMall.Customer.Service.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserDto updatedUserDto);

    void deleteUser(Long userId);
}
