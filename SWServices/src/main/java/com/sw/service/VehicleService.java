package com.sw.service;

import com.sw.model.Vehicle;

import java.util.List;

public interface VehicleService extends BaseService {

    public Vehicle getByName(String name);

    public List<Vehicle> getAll();
}
