package com.maciek.view.response;

import com.maciek.view.TO.RentalTO;

import java.util.List;

/**
 * Created by Maciek on 2017-05-20.
 */
public class RentalHistoryResponse {
    private List<RentalTO> rentals;
    private List<RentalTO> currentRentals;

    public RentalHistoryResponse(List<RentalTO> rentals, List<RentalTO> currentRentals) {
        this.rentals = rentals;
        this.currentRentals = currentRentals;
    }

    public List<RentalTO> getRentals() {
        return rentals;
    }

    public List<RentalTO> getCurrentRentals() {
        return currentRentals;
    }
}
