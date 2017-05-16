package com.maciek.view.TO;

import com.maciek.persistence.model.Rental;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

/**
 * Created by Maciek on 2017-05-11.
 */
public class RentalTO {
//    private int id;
    private Date startTime;
    private Date endTime;
    private BigDecimal cost;
    private String carName;

    public RentalTO(Rental rental) {
//        this.id = rental.getId();
        this.startTime = rental.getStartDate();
        this.endTime = rental.getEndDate();
        this.cost = rental.getCost();
        this.carName = rental.getCar().getName();
    }

//    public int getId() {
//        return id;
//    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getCarName() {
        return carName;
    }
}
