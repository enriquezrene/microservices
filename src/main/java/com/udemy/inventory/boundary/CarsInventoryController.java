package com.udemy.inventory.boundary;

import com.udemy.inventory.entity.Car;
import com.udemy.inventory.entity.Manufacturer;
import com.udemy.inventory.repositories.CarRepository;
import com.udemy.inventory.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rene on 18/01/16.
 */
@RestController
@RequestMapping(value = "/manufacturers")
public class CarsInventoryController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @RequestMapping(value = "/{manufacturerId}/cars", method = RequestMethod.POST)
    public long save(@RequestBody Car car, @PathVariable long manufacturerId) {
        Manufacturer manufacturer = manufacturerRepository.findOne(manufacturerId);
        if (manufacturer == null) {
            return -1;
        }
        car.setManufacturer(manufacturer);
        return carRepository.save(car).getId();
    }

    @RequestMapping(value = "/{manufacturerId}/cars/{carId}", method = RequestMethod.GET)
    public Car find(@PathVariable long manufacturerId, @PathVariable long carId) {
        Manufacturer manufacturer = manufacturerRepository.findOne(manufacturerId);
        if (manufacturer == null) {
            return null;
        }
        return carRepository.findOne(carId);
    }

    @RequestMapping(value = "/{manufacturerId}/cars", method = RequestMethod.GET)
    public List<Car> getAll(@PathVariable long manufacturerId) {
        Manufacturer manufacturer = manufacturerRepository.findOne(manufacturerId);
        if (manufacturer == null) {
            return null;
        }
        return carRepository.findByManufacturer(manufacturer);
    }
}
