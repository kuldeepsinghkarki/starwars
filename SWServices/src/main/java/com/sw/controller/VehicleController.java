package com.sw.controller;

import com.sw.model.Vehicle;
import com.sw.service.VehicleService;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


/**
 *
 */
@RestController
@RequestMapping("/vehicle")
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
})
public class VehicleController {

    @Autowired
    VehicleService service;

    @GetMapping("/all")
    public ResponseEntity<List<Vehicle>> getAll() {
        List<Vehicle> list = service.getAll();

        for (Vehicle vehicle : list) {
            vehicle.removeLinks();
            vehicle.add(linkTo(VehicleController.class).slash(vehicle.getName()).withSelfRel());
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Vehicle> getByName(@PathVariable("name") String name) {
        Optional<Vehicle> opt = Optional.ofNullable(service.getByName(name));
        if (!opt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Vehicle vehicle = opt.get();
        vehicle.removeLinks();
        vehicle.add(linkTo(VehicleController.class).slash(vehicle.getName()).withSelfRel());
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

}
