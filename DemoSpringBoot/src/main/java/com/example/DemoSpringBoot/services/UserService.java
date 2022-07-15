package com.example.DemoSpringBoot.services;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DemoSpringBoot.entities.Users;
import com.example.DemoSpringBoot.mappers.UserMapper;
import com.example.DemoSpringBoot.models.DTO.UserDTO;
import com.example.DemoSpringBoot.repositories.UserRepository;

@Service
class UserService implements UserServiceImpl {
    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserRepository repository;

    @Override
    public UserDTO postUser(Users user) throws Exception{
        try {
            Users newUser = repository.save(user);
            return mapper.user2DTO(newUser);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<UserDTO> getAllUsers() throws Exception{
        try {
            List<Users> users = repository.findAll();
            return mapper.users2DTOs(users);
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public UserDTO getOneUser(BigInteger id) throws Exception {
        try {
            Optional<Users> user = repository.findById(id);
            return mapper.user2DTO(user.get());
        } catch (Exception exception) {
            throw exception;
        }
    }
}
