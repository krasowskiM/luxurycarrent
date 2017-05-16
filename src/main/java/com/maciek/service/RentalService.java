package com.maciek.service;

import com.maciek.persistence.model.Car;
import com.maciek.persistence.model.Rental;
import com.maciek.persistence.model.User;
import com.maciek.persistence.repo.CarRepository;
import com.maciek.persistence.repo.RentalRepository;
import com.maciek.persistence.repo.UserRepository;
import com.maciek.view.TO.RentalTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Maciek on 2017-05-10.
 */
@Service
public class RentalService {

    private RentalRepository rentalRepository;
    private UserRepository userRepository;
    private CarRepository carRepository;

    @Autowired
    public RentalService(RentalRepository rentalRepository, UserRepository userRepository, CarRepository carRepository) {
        this.rentalRepository = rentalRepository;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }


    @Transactional
    public void createNewRental(int userId, int carId) {
        User user = userRepository.findOne(userId);
        Car car = carRepository.findOne(carId);

        Rental rental = new Rental();
        rental.setStartDate(Date.from(Instant.now()));
        rental.setUser(user);
        rental.setCar(car);
        rentalRepository.save(rental);
    }

    @Transactional
    @Modifying
    public void carReturned(int rentalId) {
        Rental rental = rentalRepository.findOne(rentalId);
        rental.setEndDate(Date.from(Instant.now()));
        rental.setCost(BigDecimal.ONE);
        rentalRepository.save(rental);
    }

    @Transactional(readOnly = true)
    public List<RentalTO> getRentalTOs(){
        return rentalRepository.findAll().stream().map(RentalTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<RentalTO> getRentalListByUserId(int userId) {
        return rentalRepository.findAllByUserId(userId).stream().map(RentalTO::new).collect(Collectors.toList());
    }
}
