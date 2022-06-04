package com.sw.model;


import org.springframework.hateoas.RepresentationModel;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class People extends RepresentationModel<People> {

    private String name;
    private String gender;
    private String eyeColor;
    private String hairColor;
    private Set<String> films;


    public People(String name, String gender, String eyeColor, String hairColor, String... films) {
        this.name = name;
        this.gender = gender;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.films = new HashSet<String>(Arrays.stream(films).collect(Collectors.toSet()));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public Set<String> getFilms() {
        return films;
    }

    public void setFilms(Set<String> films) {
        this.films = films;
    }
}
