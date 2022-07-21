package com.training.user.controllers;

import com.training.user.entities.role.Role;
import com.training.user.entities.role.RoleName;
import com.training.user.entities.user.User;
import com.training.user.models.UserDto;
import com.training.user.payload.ApiResponse;
import com.training.user.payload.JwtAuthenticationResponse;
import com.training.user.payload.LoginRequest;
import com.training.user.repositories.RoleRepository;
import com.training.user.repositories.UserRepository;
import com.training.user.security.JwtTokenProvider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/public/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/signin")
    public JwtAuthenticationResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest){


        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateToken(authentication);

        return new JwtAuthenticationResponse(jwt);
    }

    @PostMapping("/signup")
    public ApiResponse registerUser(@Valid @RequestBody UserDto userDto) {
        if(userRepository.findByEmail(userDto.getEmail()) != null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Email is already taken"
            );
        }
        String hashPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(hashPassword);

        User user = modelMapper.map(userDto,User.class);

        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByName(RoleName.ROLE_USER));
        user.setRoles(roles);

        User result = userRepository.save(user);

        return new ApiResponse(true,"User registered successfully");
    }

}
