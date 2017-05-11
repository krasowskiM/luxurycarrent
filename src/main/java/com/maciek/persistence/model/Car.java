package com.maciek.persistence.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Maciek on 2017-05-10.
 */
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "reg_number")
    private String regNumber;

    @Column(name = "state_of_counter")
    private int stateOfCounter;

    @Column(name = "seats")
    private int seats;

    @Column(name = "daily_rental_cost")
    private BigDecimal dailyRentalCost;

    @Column(name = "km_rental_cost")
    private BigDecimal kmRentalCost;

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public int getStateOfCounter() {
        return stateOfCounter;
    }

    public void setStateOfCounter(int stateOfCounter) {
        this.stateOfCounter = stateOfCounter;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public BigDecimal getDailyRentalCost() {
        return dailyRentalCost;
    }

    public void setDailyRentalCost(BigDecimal dailyRentalCost) {
        this.dailyRentalCost = dailyRentalCost;
    }

    public BigDecimal getKmRentalCost() {
        return kmRentalCost;
    }

    public void setKmRentalCost(BigDecimal kmRentalCost) {
        this.kmRentalCost = kmRentalCost;
    }
}
