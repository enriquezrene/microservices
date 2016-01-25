package com.udemy.inventory.boundary;

import com.udemy.inventory.entity.Car;
import com.udemy.inventory.entity.Manufacturer;
import com.udemy.inventory.exceptions.ResourceNotFoundException;
import com.udemy.inventory.repositories.CarRepository;
import com.udemy.inventory.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<?> save(@RequestBody Car car, @PathVariable long manufacturerId) {
        Manufacturer manufacturer = getManufacturer(manufacturerId);
        car.setManufacturer(manufacturer);
        car = carRepository.save(car);

        URI savedCarUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(car.getId()).toUri();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(savedCarUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{manufacturerId}/cars/{carId}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable long manufacturerId, @PathVariable long carId) {
        Manufacturer manufacturer = getManufacturer(manufacturerId);

        Car car = carRepository.findOne(carId);
        if (car == null) {
            throw new ResourceNotFoundException("Car with id: " + carId + " not found.");
        }
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @RequestMapping(value = "/{manufacturerId}/cars", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(@PathVariable long manufacturerId) {
        Manufacturer manufacturer = getManufacturer(manufacturerId);
        List<Car> cars = carRepository.findByManufacturer(manufacturer);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    private Manufacturer getManufacturer(@PathVariable long manufacturerId) {
        Manufacturer manufacturer = manufacturerRepository.findOne(manufacturerId);
        if (manufacturer == null) {
            throw new ResourceNotFoundException("Manufacturer with id: " + manufacturerId + " not found.");
        }
        return manufacturer;
    }
}
