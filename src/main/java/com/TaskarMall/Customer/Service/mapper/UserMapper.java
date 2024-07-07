package com.TaskarMall.Customer.Service.mapper;

import com.TaskarMall.Customer.Service.dto.UserDto;
import com.TaskarMall.Customer.Service.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getMobileNumber(),
                user.getEmail()
        );
    }

    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getMobileNumber(),
                userDto.getEmail()
        );
    }
}
