package com.training.user.services;

import com.training.user.entities.User;
import com.training.user.exceptions.AppException;
import com.training.user.repositories.UserRepository;
import com.training.user.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        log.info("saving new user {} {} to database",user.getFirstName(),user.getLastName());

        return userRepository.save(user);
    }

    @Override
    public User getUserById(int userId) {
        log.info("Fetching user with id {} ",userId);

        User user = userRepository.findById(userId);
        if(user == null) {
//            throw new AppException(404,"user not found");
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
        User UserDB = userRepository.findById(user.getId());
        if(UserDB == null){

            throw new AppException(404,"User not found");
        }
        return userRepository.save(user);
    }

    @Override
    public int removeUser(int userId) {
         log.info("remove user with id {} ",userId);

         User user = userRepository.findById(userId);
         if(user == null) {
//            throw new AppException(404,"user not found");
//            return null;
        }

         userRepository.delete(user);
         return userId;
    }


}
