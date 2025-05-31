package com.javaguide.Spring_boot_restful_webservices.service;

import com.javaguide.Spring_boot_restful_webservices.dto.UserDto;
import com.javaguide.Spring_boot_restful_webservices.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long userid);
    List<UserDto> getAll();
    UserDto updateUser(UserDto user);
    void deleteUser(Long userId);
}
