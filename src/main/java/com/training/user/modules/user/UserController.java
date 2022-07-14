package com.training.user.modules.user;

import com.training.user.dtos.UserDto;
import com.training.user.entities.User;
import com.training.user.serviceInterfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/protected")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping("users")
    public List<UserDto> getUsers(){

        List<User> users = userService.getUsers();

        return  users.stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    @GetMapping("users/{userId}")
    public UserDto getUserById(@PathVariable int userId){
        User user = userService.getUserById(userId);

        UserDto userDto = modelMapper.map(user,UserDto.class);
        return userDto;
    }

//    @GetMapping("users/{email}")
//    public User getUserByEmail(@PathVariable String email){
//        return userService.getUserByEmail(email);
//    }

    @PostMapping("users/save")
    public UserDto saveUser(@RequestBody @Valid UserDto userDto){
        User user = modelMapper.map(userDto,User.class);

        User userEntity = userService.saveUser(user);

        UserDto result =modelMapper.map(userEntity,UserDto.class);
        return result;
    }

}
