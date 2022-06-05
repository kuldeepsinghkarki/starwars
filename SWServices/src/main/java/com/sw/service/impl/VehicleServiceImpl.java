package com.sw.service.impl;

import com.sw.data.VehicleRepository;
import com.sw.model.Vehicle;
import com.sw.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl extends BaseServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;

    @Override
    public List<Vehicle> getAll() {
        return repository.all();
    }

    @Override
    public Vehicle getByName(String name) {
        return repository.search(name);
    }
}
