package com.javaguide.Spring_boot_restful_webservices.mapper;

import com.javaguide.Spring_boot_restful_webservices.dto.UserDto;
import com.javaguide.Spring_boot_restful_webservices.entity.User;

public class UserMapper {
    //convert user JPA to DTO
    public static UserDto mapToUserDto(User user){
    UserDto userDto=new UserDto(
            user.getId(),
            user.getFirstname(),
            user.getLastname(),user.getEmail()
    );
    return userDto;
    }

    //Convert user DTO to JPA
    public static User mapToUser(UserDto userDto){
        User user=new User(
                userDto.getId(),
                userDto.getFirstname(),
                userDto.getLastname(),
                userDto.getEmail()
        );
        return user;
    }
}
