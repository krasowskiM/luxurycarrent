package com.maciek.view.controller;

import com.maciek.exception.InvalidCredentialsException;
import com.maciek.service.CarService;
import com.maciek.service.UserService;
import com.maciek.view.TO.CarTO;
import com.maciek.view.request.RegistrationRequest;
import com.maciek.view.response.RegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Maciek on 2017-05-10.
 */
@RestController
public class WebController {

    private UserService userService;
    private CarService carService;

    @Autowired
    public WebController(UserService userService, CarService carService) {
        this.userService = userService;
        this.carService = carService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.PUT)
    public RegistrationResponse registerUser(RegistrationRequest registrationRequest) throws InvalidCredentialsException {
        userService.registerUser(registrationRequest.getEmail(), registrationRequest.getPassword());
        return new RegistrationResponse("User registered!");
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public List<CarTO> listOfCars(){
        return carService.getCarList();
    }
}
