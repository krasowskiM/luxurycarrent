package com.maciek.view.TO;

import com.maciek.persistence.model.Rental;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Created by Maciek on 2017-05-11.
 */
public class RentalTO {
    private int id;
    private Instant startTime;
    private Instant endTime;
    private BigDecimal cost;

    public RentalTO(Rental rental) {
        this.id = rental.getId();
        this.startTime = rental.getStartDate();
        this.endTime = rental.getEndDate();
        this.cost = rental.getCost();
    }
}
