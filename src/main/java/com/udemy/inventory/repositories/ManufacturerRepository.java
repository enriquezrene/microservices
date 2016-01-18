package com.udemy.inventory.repositories;

import com.udemy.inventory.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rene on 18/01/16.
 */
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

}
