package com.udemy.inventory.boundary;

import com.udemy.inventory.entity.Manufacturer;
import com.udemy.inventory.exceptions.ResourceNotFoundException;
import com.udemy.inventory.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * Created by rene on 18/01/16.
 */
@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Manufacturer manufacturer) {
        manufacturer = manufacturerRepository.save(manufacturer);

        URI savedManufacturerUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(manufacturer.getId()).toUri();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(savedManufacturerUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{manufacturerId}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable long manufacturerId) {
        Manufacturer manufacturer = manufacturerRepository.findOne(manufacturerId);
        if (manufacturer == null) {
            throw new ResourceNotFoundException("Manufacturer not found with id: " + manufacturerId);
        }
        return new ResponseEntity<>(manufacturer, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(manufacturerRepository.findAll(), HttpStatus.OK);
    }
}
