package org.narainox.blog.application.backend.controllers;

import org.narainox.blog.application.backend.payloads.UserDto;
import org.narainox.blog.application.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
    {
        UserDto user = userService.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUserHandler(@RequestBody UserDto userDto,@PathVariable Long userId)
    {
        UserDto user = userService.updateUser(userDto,userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserHandler(@PathVariable Long userId)
    {
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUserHandler()
    {
        List<UserDto> user = userService.getAllUser();
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> getAllUserHandler(@PathVariable Long userId)
    {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User Deleted !", HttpStatus.FOUND);
    }


}
