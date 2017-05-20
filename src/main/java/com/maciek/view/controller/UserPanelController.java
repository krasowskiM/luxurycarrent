package com.maciek.view.controller;

import com.maciek.persistence.model.User;
import com.maciek.service.CarService;
import com.maciek.service.RentalService;
import com.maciek.service.UserService;
import com.maciek.utils.AuthenticationContext;
import com.maciek.view.TO.CarTO;
import com.maciek.view.TO.RentalTO;
import com.maciek.view.TO.UserTO;
import com.maciek.view.response.RentalHistoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Maciek on 2017-05-10.
 */
@RestController
public class UserPanelController {

//    private UserService userService;
    private CarService carService;
    private RentalService rentalService;

    @Autowired
    public UserPanelController(//UserService userService,
                               CarService carService,
                               RentalService rentalService) {
//        this.userService = userService;
        this.carService = carService;
        this.rentalService = rentalService;
    }

    @RequestMapping(value = "/rentals", method = RequestMethod.GET)
    public RentalHistoryResponse rentals() {
        return rentalService.getRentalListByUserId(AuthenticationContext.getCurrentUsersId());
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public List<CarTO> carList() {
        return carService.getCarList();
    }

//    @RequestMapping(value = "/userdata", method = RequestMethod.GET)
//    public UserTO userData() {
//        return new UserTO(AuthenticationContext.getCurrentUsersId());
//    }
}
