package com.sw.controller;

import com.sw.exceptions.SWResourceNotFoundException;
import com.sw.model.Film;
import com.sw.service.FilmService;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@PreAuthorize("hasAnyRole('ADMIN')")
@RestController
@RequestMapping("/film")
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
})
public class FilmsController {

    @Autowired
    FilmService service;


    @GetMapping("/all")
    public ResponseEntity<List<Film>> getAllFilms() {
        List<Film> films = service.getAll();
        for (Film film : films) {
            film.removeLinks();
            film.add(linkTo(FilmsController.class).slash(film.getName()).withSelfRel());
        }
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Film> getFilm(@PathVariable("name") String name) {
        Optional<Film> filmOpt = Optional.ofNullable(service.getByName(name));
        if (!filmOpt.isPresent()) {
            throw new SWResourceNotFoundException(name + "is not found");
        }
        Film film = filmOpt.get();
        film.removeLinks();
        film.add(linkTo(FilmsController.class).slash(film.getName()).withSelfRel());
        return new ResponseEntity<>(film, HttpStatus.OK);
    }

}
