package com.training.user.services;

import com.training.user.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUserByAccountNumber(String accountNumber);
    List<User> getUsers();

    User updateUser(User user);

    String removeUser(String accountNumber);
}
