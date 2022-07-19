package com.training.user.controllers;

import com.training.user.models.UserDto;
import com.training.user.entities.User;
import com.training.user.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/public/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

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
    public UserDto saveUser(@RequestBody @Valid UserDto userDto){

        User user = modelMapper.map(userDto,User.class);

        User userEntity = userService.saveUser(user);

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
