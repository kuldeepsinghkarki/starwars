package com.sw.data;

import com.sw.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Vehicle Repository for vehicles services.
 */
@Repository
public class VehicleRepository implements SwRepository<Vehicle> {

    /**
     * In memory repository data for Vehicles
     */
    private static Map<String, Vehicle> repo = new HashMap<>();

    static {
        repo.put("Vehicle1", new Vehicle("Vehicle1", "Truck", "Ford"));
        repo.put("Vehicle2", new Vehicle("Vehicle2", "Car", "Ford"));
        repo.put("Vehicle3", new Vehicle("Vehicle3", "Bus", "GM"));
    }


    /**
     * @return Vehicles list
     */
    @Override
    public List<Vehicle> all() {
        return (List<Vehicle>) repo.values().stream().collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * @param name
     * @return Vehicle matching search parameter name
     */
    @Override
    public Vehicle search(String name) {
        return repo.get(name);
    }
}
