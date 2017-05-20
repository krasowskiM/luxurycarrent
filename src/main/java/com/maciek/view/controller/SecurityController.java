package com.maciek.view.controller;

import com.maciek.exception.InvalidCredentialsException;
import com.maciek.exception.InvalidPasswordException;
import com.maciek.service.UserService;
import com.maciek.view.request.LoginRequest;
import com.maciek.view.request.RegistrationRequest;
import com.maciek.view.response.LoginResponse;
import com.maciek.view.response.RegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Maciek on 2017-05-16.
 */
@RestController
public class SecurityController {

    private UserService userService;

    @Autowired
    public SecurityController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.PUT)
    public RegistrationResponse registerUser(@RequestBody RegistrationRequest registrationRequest) throws InvalidCredentialsException {
        userService.registerUser(registrationRequest.getEmail(), registrationRequest.getPassword());

        return new RegistrationResponse("User registered!");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws InvalidCredentialsException, InvalidPasswordException {
        return userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
    }
}
