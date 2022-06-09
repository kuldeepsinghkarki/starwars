package com.sw.controller;

import com.sw.exceptions.DBConnectionException;
import com.sw.service.PeopleService;
import com.sw.service.SWUtils;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
})
public class AdminController {

    @Autowired
    PeopleService peopleService;

    @GetMapping("/toggle")
    public ResponseEntity<?> toggleService() {
        SWUtils.toggleService();

        boolean switchValue = SWUtils.isActive();
        if (switchValue) {
            try {
                peopleService.clearBufferRequests();
            } catch (DBConnectionException e) {
                // log error;
            }
        }
        String repoState = switchValue == true ? "DB connection is Back" : "DB connection is Lost";
        return new ResponseEntity<>(repoState, HttpStatus.OK);
    }
}
