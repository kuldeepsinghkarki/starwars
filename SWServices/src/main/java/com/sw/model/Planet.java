package com.sw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Planet entity using Spring Data Rest
 */
@Entity
public class Planet {

    private @Id
    @GeneratedValue
    Long id;

    private String name;
    private String climate;
    private Long diameter;

    public Planet(){

    }

    public Planet(String name, String climate, Long diameter) {
        this.name = name;
        this.climate = climate;
        this.diameter = diameter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public Long getDiameter() {
        return diameter;
    }

    public void setDiameter(Long diameter) {
        this.diameter = diameter;
    }
}
