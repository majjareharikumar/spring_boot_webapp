package com.javaguide.Spring_boot_restful_webservices.controller;

import com.javaguide.Spring_boot_restful_webservices.dto.UserDto;
import com.javaguide.Spring_boot_restful_webservices.entity.User;
import com.javaguide.Spring_boot_restful_webservices.exception.ErrorDetails;
import com.javaguide.Spring_boot_restful_webservices.exception.UserNotFoundException;
import com.javaguide.Spring_boot_restful_webservices.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@Tag(
        name = "CRUD REST APIs for user resource",
        description = "CRUD REST APIs :- create user, update user, get user, get all users, delete user"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {


    @Autowired
    private UserService userService;

    //create user REST API
    //http://localhost:8080/api/users/createuser
    @Operation(
            summary = "Create user REST API",
            description = "Create new user "
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP_STATUS 201 CREATED"
    )
    @PostMapping("/createuser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    //GetUser by id
    //http://localhost:8080/api/users/2
    @Operation(
            summary = "Get user by id REST API",
            description = "Get user by passing user id "
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP_STATUS 200 SUCCESS"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getbyid(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

    //GetAllUsers
    //http://localhost:8080/api/users/AllUsers
    @Operation(
            summary = "Get all users REST API",
            description = "Get all users from data base "
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP_STATUS 200 SUCCESS"
    )
    @GetMapping("/AllUsers")
    public ResponseEntity<List<UserDto>> GetAllUsers(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    //UpdateUser
    //http://localhost:8080/api/users/1
    @Operation(
            summary = "Update user REST API",
            description = "Update existing user with new values "
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP_STATUS 20 SUCCESS"
    )
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userid, @RequestBody UserDto user){
        user.setId(userid);
        UserDto updatedUser=userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //DeleteUser
    //http://localhost:8080/api/users/1
    @Operation(
            summary = "Delete user REST API",
            description = "Delete user "
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP_STATUS 200 SUCCESS"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);

        return new ResponseEntity<>("User delete Successfully", HttpStatus.OK);
    }

//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handlerUserNotFoundException(UserNotFoundException exception, WebRequest webRequest){
//        ErrorDetails errorDetails=new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//    }

}
