package com.sw.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sw.controller.VehicleController;
import com.sw.data.VehicleRepository;
import com.sw.model.Vehicle;
import com.sw.security.TokenProvider;
import com.sw.security.UserDetailsServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({VehicleController.class, VehicleService.class, UserDetailsServiceImpl.class, TokenProvider.class})
class VehicleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    VehicleRepository vehicleRepository;


    @Test
    void findByNameTest() throws Exception {
        final String VEHICLE_NAME = "testvehicle";
        Vehicle vehicle = new Vehicle(VEHICLE_NAME, "Truck", "Ford");
        Mockito.when(vehicleRepository.search(VEHICLE_NAME)).thenReturn(vehicle);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/vehicle/" + VEHICLE_NAME)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()
        ).andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", Matchers.is(VEHICLE_NAME)));
    }

    @Test
    void findByNameNotFoundTest() throws Exception {
        final String VEHICLE_NAME = "testvehicle";
        Vehicle vehicle = new Vehicle(VEHICLE_NAME, "Truck", "Ford");


        Mockito.when(vehicleRepository.search(VEHICLE_NAME)).thenReturn(vehicle);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/vehicle/not" + VEHICLE_NAME)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNotFound());

    }

}
