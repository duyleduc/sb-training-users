package com.example.springrestapi.controllers.publiccontrollers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrestapi.configuration.Config;
import com.example.springrestapi.dtos.UserDto;
import com.example.springrestapi.services.UserService;

@RestController
@RequestMapping(Config.BASE_PUBLIC_URL)
public class Register {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto body) throws Exception {

        UserDto res = userService.registerUser(body);
        return new ResponseEntity<UserDto>(res, HttpStatus.OK);

    }

}
