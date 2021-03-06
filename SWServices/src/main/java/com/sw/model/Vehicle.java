package com.sw.model;

import org.springframework.hateoas.RepresentationModel;

/**
 * Vehicle representation model
 */
public class Vehicle extends RepresentationModel<People> {

    private String name;
    private String model;
    private String manufacturer;

    public Vehicle(String name, String model, String manufacturer) {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
