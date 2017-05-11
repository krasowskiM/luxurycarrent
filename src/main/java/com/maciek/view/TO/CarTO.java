package com.maciek.view.TO;

import com.maciek.persistence.model.Car;

import java.math.BigDecimal;

/**
 * Created by Maciek on 2017-05-11.
 */
public class CarTO {
    private int id;
    private String name;
    private String regNumber;
    private int stateOfCounter;
    private int seats;
    private BigDecimal dailyRentalCost;
    private BigDecimal kmRentalCost;

    public CarTO(Car car) {
        this.id = car.getId();
        this.name = car.getName();
        this.regNumber = car.getRegNumber();
        this.stateOfCounter = car.getStateOfCounter();
        this.seats = car.getSeats();
        this.dailyRentalCost = car.getDailyRentalCost();
        this.kmRentalCost = car.getKmRentalCost();
    }
}
