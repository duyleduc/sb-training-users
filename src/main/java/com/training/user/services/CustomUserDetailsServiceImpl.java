package com.training.user.services;

import com.training.user.entities.user.User;
import com.training.user.repositories.UserRepository;
import com.training.user.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail)  {

        User user = userRepository.findByEmail(usernameOrEmail);

        return UserPrincipal.create(user);
    }

    @Override
    public UserDetails loadUserByAccountNumber(String accountNumber) {
        User user = userRepository.findByAccountNumber(accountNumber);

        return UserPrincipal.create(user);
    }
}
