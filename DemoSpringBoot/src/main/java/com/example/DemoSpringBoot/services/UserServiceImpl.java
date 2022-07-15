package com.example.DemoSpringBoot.services;

import java.math.BigInteger;
import java.util.List;

import com.example.DemoSpringBoot.entities.Users;
import com.example.DemoSpringBoot.models.DTO.UserDTO;

public interface UserServiceImpl {
    UserDTO postUser(Users user)throws Exception;
    List<UserDTO> getAllUsers() throws Exception;
    UserDTO getOneUser(BigInteger id) throws Exception;
}
