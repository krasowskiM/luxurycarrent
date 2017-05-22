package com.maciek.view.TO;

import com.maciek.persistence.model.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Maciek on 2017-05-11.
 */
public class UserTO {
    private BigDecimal funds;

    public UserTO(User user) {
        this.funds = user.getFunds();
    }

    public BigDecimal getFunds() {
        return funds;
    }
}
