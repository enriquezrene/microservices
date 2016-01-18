package com.udemy.inventory.boundary;

import com.udemy.inventory.entity.Manufacturer;
import com.udemy.inventory.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rene on 18/01/16.
 */
@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @RequestMapping(method = RequestMethod.POST)
    public long save(@RequestBody Manufacturer manufacturer) {
        manufacturer = manufacturerRepository.save(manufacturer);
        return manufacturer.getId();
    }

    @RequestMapping(value = "/{manufacturerId}", method = RequestMethod.GET)
    public Manufacturer find(@PathVariable long manufacturerId) {
        return manufacturerRepository.findOne(manufacturerId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Manufacturer> getAll() {
        return manufacturerRepository.findAll();
    }
}
