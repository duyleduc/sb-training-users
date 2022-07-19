package com.training.user.controllers;

import com.training.user.models.UserDto;
import com.training.user.entities.user.User;
import com.training.user.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/public/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<UserDto> getUsers(){

        List<User> users = userService.getUsers();

        return  users.stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    @GetMapping("{accountNumber}")
    public UserDto getUserById(@PathVariable String accountNumber){
        User user = userService.getUserByAccountNumber(accountNumber) ;

        UserDto userDto = modelMapper.map(user,UserDto.class);
        return userDto;
    }

//    @GetMapping("users/{email}")
//    public User getUserByEmail(@PathVariable String email){
//        return userService.getUserByEmail(email);
//    }

    @PostMapping
    public UserDto saveUser(@RequestBody @Valid UserDto userDto) throws MessagingException, UnsupportedEncodingException {

        User user = modelMapper.map(userDto,User.class);

        User userEntity = userService.saveUser(user);
        userService.generatedOTP(user);

        UserDto result = modelMapper.map(userEntity,UserDto.class);
        return result;
    }

    @PatchMapping("{accountNumber}")
    public User updateUser(@RequestBody @Valid UserDto userDto,@PathVariable String  accountNumber) {
        User user = modelMapper.map(userDto,User.class);
        user.setAccountNumber(accountNumber);

        return userService.updateUser(user);
    }


    @DeleteMapping("{accountNumber}")
    public String removeUser(@PathVariable String accountNumber){
        return userService.removeUser(accountNumber);
    }

}
