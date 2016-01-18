package com.udemy.inventory.repositories;

import com.udemy.inventory.entity.Car;
import com.udemy.inventory.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by rene on 18/01/16.
 */
public interface CarRepository extends JpaRepository<Car, Long> {

    public List<Car> findByManufacturer(Manufacturer manufacturer);
}
