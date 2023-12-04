package org.narainox.blog.application.backend.service.impl;

import org.modelmapper.ModelMapper;
import org.narainox.blog.application.backend.entity.User;
import org.narainox.blog.application.backend.exception.ResourceNotFoundException;
import org.narainox.blog.application.backend.payloads.UserDto;
import org.narainox.blog.application.backend.repository.UserRepository;
import org.narainox.blog.application.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User save = userRepository.save(user);
        return modelMapper.map(save, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto,Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User save = userRepository.save(user);
        return modelMapper.map(save, UserDto.class);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserDto> userDtos=new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user:users)
        {
            userDtos.add(modelMapper.map(user, UserDto.class));
        }
        return userDtos;
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
        userRepository.delete(user);
    }
}
