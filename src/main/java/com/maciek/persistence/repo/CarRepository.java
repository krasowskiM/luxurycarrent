package com.maciek.persistence.repo;

import com.maciek.persistence.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Maciek on 2017-05-10.
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}
