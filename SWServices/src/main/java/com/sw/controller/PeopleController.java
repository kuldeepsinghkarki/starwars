package com.sw.controller;

import com.sw.model.People;
import com.sw.service.PeopleService;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/people")
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
})
public class PeopleController {

    @Autowired
    PeopleService service;


    @GetMapping("/all")
    public ResponseEntity<List<People>> getAllPeople() {
        List<People> peopleList = service.getAll();
        return new ResponseEntity<>(peopleList, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<People> getPeople(@PathVariable("name") String name) {
        //People people = service.getByName(name);
        Optional<People> peopleOpt = Optional.ofNullable(service.getByName(name));
        if (!peopleOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        People people = peopleOpt.get();
        people.removeLinks();
        people.add(linkTo(PeopleController.class).slash(people.getName()).withSelfRel());
        if (people.getFilms() != null) {
            for (String filmName : people.getFilms()) {
                Link filmLink = linkTo(methodOn(FilmsController.class).getFilm(filmName)).withRel("Films");
                people.add(filmLink);
            }
        }

        return new ResponseEntity<>(people, HttpStatus.OK);
    }

}
