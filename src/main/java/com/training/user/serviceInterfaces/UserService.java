package com.training.user.serviceInterfaces;

import com.training.user.dtos.UserDto;
import com.training.user.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUserById(int userId);
    List<User> getUsers();
}
