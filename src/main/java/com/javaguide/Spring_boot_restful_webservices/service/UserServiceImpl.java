package com.javaguide.Spring_boot_restful_webservices.service;

import com.javaguide.Spring_boot_restful_webservices.dto.UserDto;
import com.javaguide.Spring_boot_restful_webservices.entity.User;
import com.javaguide.Spring_boot_restful_webservices.mapper.UserMapper;
import com.javaguide.Spring_boot_restful_webservices.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        //convert userDTO into user JPA entity

        User user = UserMapper.mapToUser(userDto);

        User savedUser= userRepository.save(user);

        //Convert User JPA entity to User DTO
        UserDto savedUserDto=UserMapper.mapToUserDto(savedUser);

        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userid) {
        Optional<User> optionalUser=userRepository.findById(userid);
        User user=optionalUser.get();
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> listOfUsers=userRepository.findAll();
        return listOfUsers.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser=userRepository.findById(user.getId()).get();
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());
        User updatedUser=userRepository.save(existingUser);
        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
