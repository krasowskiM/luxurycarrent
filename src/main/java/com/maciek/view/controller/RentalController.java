package com.maciek.view.controller;

import com.maciek.service.RentalService;
import com.maciek.utils.AuthenticationContext;
import com.maciek.view.response.RentalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Maciek on 2017-05-16.
 */
@RestController
public class RentalController {

    private RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService){
        this.rentalService = rentalService;
    }

    @RequestMapping(value = "/api/rent/{id}", method = RequestMethod.PUT)
    public RentalResponse rent(@PathVariable("id") int carId){
//        User user = ;
        rentalService.createNewRental(AuthenticationContext.getCurrentUsersId(), carId);
        return new RentalResponse("Car rented!");
    }

    @RequestMapping(value = "/api/return/{id}", method = RequestMethod.POST)
    public RentalResponse returnCar(@PathVariable("id") int rentalId){
        rentalService.carReturned(rentalId);
        return new RentalResponse("Car returned!");
    }
}
