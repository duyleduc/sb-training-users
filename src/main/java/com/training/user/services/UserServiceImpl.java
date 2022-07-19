package com.training.user.services;

import com.training.user.entities.User;
import com.training.user.exceptions.AppException;
import com.training.user.repositories.UserRepository;
import com.training.user.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        log.info("saving new user {} {} {} {} to database",user.getFirstName(),user.getLastName(),user.getAccountNumber(),user.getCreatedAt());

        return userRepository.save(user);
    }

    @Override
    public User getUserByAccountNumber(String accountNumber) {
        log.info("Fetching user with Account Number {} ",accountNumber);

        User user = userRepository.findByAccountNumber(accountNumber);
        if(user == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        return user;
    }


    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        log.info("update user {} {} to database",user.getFirstName(),user.getLastName());
        User UserDB = userRepository.findByAccountNumber(user.getAccountNumber());
        if(UserDB == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        user.setCreatedAt(UserDB.getCreatedAt());
        user.setAccountNumber(UserDB.getAccountNumber());
        userRepository.save(user);
        return userRepository.findByAccountNumber(user.getAccountNumber());
    }

    @Override
    public String removeUser(String accountNumber) {
         log.info("remove user with Account Number {} ",accountNumber);

         User user = userRepository.findByAccountNumber(accountNumber);
         if(user == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
             );
        }

         userRepository.delete(user);
         return accountNumber;
    }


}
