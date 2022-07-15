package com.training.user.services;

import com.training.user.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUserById(int userId);
    List<User> getUsers();

    User updateUser(User user);

    int removeUser(int userId);
}
