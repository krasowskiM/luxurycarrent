package com.maciek.service;

import com.maciek.persistence.repo.RentalRepository;
import com.maciek.view.TO.RentalTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Maciek on 2017-05-10.
 */
@Service
public class RentalService {

    private RentalRepository rentalRepository;

    @Autowired
    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Transactional
    public void createNewRental() {

    }

    @Transactional
    public List<RentalTO> getRentalTOs(){
        return rentalRepository.findAll().stream().map(RentalTO::new).collect(Collectors.toList());
    }

    public List<RentalTO> getRentalListByUserId(int userId) {
        return rentalRepository.findAllByUserId(userId).stream().map(RentalTO::new).collect(Collectors.toList());
    }
}
