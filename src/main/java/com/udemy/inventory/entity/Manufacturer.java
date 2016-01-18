package com.udemy.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rene on 18/01/16.
 */
@Data
@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "manufacturer")
    private List<Car> cars;
}
