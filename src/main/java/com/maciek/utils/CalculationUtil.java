package com.maciek.utils;

import com.maciek.persistence.model.Rental;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;

/**
 * Created by Maciek on 2017-05-22.
 */
public class CalculationUtil {

    public static BigDecimal calculateRentalCost(Rental rental, int stateOfCounter){
        Instant startDate = rental.getStartDate().toInstant();
        String diffOfDays = "" + (double) (Duration.between(startDate, Instant.now()).toHours() / 24);
        int kmDiff = stateOfCounter - rental.getCar().getStateOfCounter();

        return new BigDecimal(diffOfDays).multiply(rental.getCar().getDailyRentalCost())
                .add(rental.getCar().getKmRentalCost().multiply(new BigDecimal(kmDiff)));
    }
}
