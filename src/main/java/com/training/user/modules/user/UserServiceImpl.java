package com.training.user.modules.user;

import com.training.user.dtos.UserDto;
import com.training.user.entities.User;
import com.training.user.serviceInterfaces.UserService;
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
        return userRepository.findById(userId);
    }


    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
