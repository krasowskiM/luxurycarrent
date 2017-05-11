package com.maciek.service;

import com.maciek.persistence.repo.CarRepository;
import com.maciek.view.TO.CarTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Maciek on 2017-05-11.
 */
@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public List<CarTO> getCarList() {
        return carRepository.findAll().stream().map(CarTO::new).collect(Collectors.toList());
    }
}
