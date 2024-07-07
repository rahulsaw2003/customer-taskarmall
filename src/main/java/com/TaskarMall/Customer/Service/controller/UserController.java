package com.TaskarMall.Customer.Service.controller;
import com.TaskarMall.Customer.Service.dto.UserDto;
import com.TaskarMall.Customer.Service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
     private UserService userService;

     // Add User Api
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser (@RequestBody UserDto userDto){
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Get User Api
    @GetMapping("/get/{Id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("Id") Long userId){
        UserDto foundUser = userService.getUserById(userId);
        return new ResponseEntity<>(foundUser,HttpStatus.OK);
    }

    // Get all users api
    @GetMapping("/get-all")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    // Update user
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody UserDto updateUser){
        UserDto updatedUser = userService.updateUser(userId, updateUser);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok("User Deleted Successfully!");
    }
}
