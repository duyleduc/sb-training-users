package com.example.DemoSpringBoot.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoSpringBoot.Beans.Users;
import com.example.DemoSpringBoot.Beans.dtos.RegisterUserDTO;
import com.example.DemoSpringBoot.Mappings.UserMapper;
import com.example.DemoSpringBoot.Repositoriez.UserRepository;

@RestController
@RequestMapping(value = "api/v1/protected/users")
public class UserController {
    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserRepository repository;

    @GetMapping(value = "")
    public List<RegisterUserDTO> GetAllUser() {
        try {
            List<Users> users = repository.findAll();
            return mapper.users2DTOs(users);
        } catch (Exception exception) {
            throw exception;
        }
    }
    
    @PostMapping(value = "")
    public RegisterUserDTO postUser(@Valid@RequestBody Users user) throws Exception {
        try {
            Users newUser = repository.save(user);
            return mapper.user2DTO(newUser);
        } catch (Exception e) {
            throw e;
        }
        
    }

}
