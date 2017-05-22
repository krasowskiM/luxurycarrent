package com.maciek.view.controller;

import com.maciek.service.RentalService;
import com.maciek.utils.AuthenticationContext;
import com.maciek.view.request.ReturnRequest;
import com.maciek.view.response.RentalResponse;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public RentalResponse returnCar(@PathVariable("id") int rentalId, @RequestBody ReturnRequest returnRequest){
        rentalService.carReturned(rentalId, returnRequest.getStateOfCounter());
        return new RentalResponse("Car returned!");
    }
}
