package com.maciek.view.response;

import com.maciek.view.TO.RentalTO;

import java.util.List;

/**
 * Created by Maciek on 2017-05-20.
 */
public class RentalHistoryResponse {
    private List<RentalTO> rentals;
    private RentalTO currentRental;

    public RentalHistoryResponse(List<RentalTO> rentals, RentalTO currentRental) {
        this.rentals = rentals;
        this.currentRental = currentRental;
    }

    public List<RentalTO> getRentals() {
        return rentals;
    }

    public RentalTO getCurrentRental() {
        return currentRental;
    }
}
