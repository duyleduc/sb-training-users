package com.example.DemoSpringBoot.controllerz;

import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoSpringBoot.entities.Users;
import com.example.DemoSpringBoot.models.DTO.UserDTO;
import com.example.DemoSpringBoot.services.UserServiceImpl;


@RestController
@RequestMapping(value = "api/v1/protected/users")
public class UserController {
    @Autowired
    UserServiceImpl uService;

    @GetMapping(value = "")
    public List<UserDTO> getAllUsers() throws Exception{
       return uService.getAllUsers();
    }
    @GetMapping(value = "/{id}")
    public UserDTO getOneByID(@RequestParam BigInteger id) throws Exception{
       return uService.getOneUser(id);
    }
    
    @PostMapping(value = "")
    public UserDTO postUser(@Valid@RequestBody Users user) throws Exception {
        return uService.postUser(user);
    }

}
