package com.maciek.view.TO;

import com.maciek.persistence.model.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Maciek on 2017-05-11.
 */
public class UserTO {
    private int id;
    private BigDecimal funds;
    private List<RentalTO> rentals;

    public UserTO(User user) {
        this.id = user.getId();
        this.funds = user.getFunds();
    }

    public void setRentals(List<RentalTO> rentals) {
        this.rentals = rentals;
    }
}
