package com.example.springrestapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.springrestapi.dtos.UserDto;
import com.example.springrestapi.entities.User;
import com.example.springrestapi.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDto registerUser(UserDto user) throws Exception {

        User existedUser = userRepository.findByEmail(user.getEmail());
        if (existedUser != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "User with " + user.getEmail() + " already existed");
        }
        userRepository.save(user.toUser());
        return user;
    }
}
