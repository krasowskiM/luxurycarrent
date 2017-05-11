package com.maciek.persistence.repo;

import com.maciek.persistence.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Maciek on 2017-05-10.
 */
@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {
    List<Rental> findAllByUserId(int userId);
}
