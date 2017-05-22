package com.maciek.service;

import com.maciek.persistence.model.Car;
import com.maciek.persistence.model.Rental;
import com.maciek.persistence.model.User;
import com.maciek.persistence.repo.CarRepository;
import com.maciek.persistence.repo.RentalRepository;
import com.maciek.persistence.repo.UserRepository;
import com.maciek.view.TO.RentalTO;
import com.maciek.view.response.RentalHistoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
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

        rentalRepository.save(new Rental(user, car, Date.from(Instant.now())));
    }

    @Transactional
    public void carReturned(int rentalId) {
        Rental rental = rentalRepository.findOne(rentalId);
        rental.setEndDate(Date.from(Instant.now()));
        rental.setCost(rental.getCar().getDailyRentalCost().add(rental.getCar().getKmRentalCost()));
        rentalRepository.save(rental);

    }

    @Transactional(readOnly = true)
    public RentalHistoryResponse getRentalListByUserId(int userId) {
        List<RentalTO> rentals = rentalRepository.findAllByUserId(userId).stream()
                .map(RentalTO::new).collect(Collectors.toList());
        return new RentalHistoryResponse(rentals.stream().filter(rentalTO -> rentalTO.getEndTime() != null).collect(Collectors.toList())
//                ,rentals.stream().filter(rentalTO -> rentalTO.getEndTime() == null).collect(Colle
                );
    }
}
