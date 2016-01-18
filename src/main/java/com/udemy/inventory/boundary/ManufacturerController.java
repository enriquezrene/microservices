package com.udemy.inventory.boundary;

import com.udemy.inventory.entity.Manufacturer;
import com.udemy.inventory.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(method = RequestMethod.GET)
    public List<Manufacturer> getAll() {
        return manufacturerRepository.findAll();
    }
}
