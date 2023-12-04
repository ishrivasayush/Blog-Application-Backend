package org.narainox.blog.application.backend.service;

import org.narainox.blog.application.backend.entity.User;
import org.narainox.blog.application.backend.payloads.UserDto;

import java.util.List;

public interface UserService{
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,Long userId);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUser();
    void deleteUser(Long userId);
}
