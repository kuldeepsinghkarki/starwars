package com.sw.data;

import com.sw.exceptions.DBConnectionException;
import com.sw.model.People;
import com.sw.service.SWUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * PeopleRepository for people data.
 */
@Repository
public class PeopleRepository implements SwRepository<People> {

    private static Map<String, People> peopleRepo = new HashMap<>();

    static {
        peopleRepo.put("Adam", new People("Adam", "Male", "Black", "Grey", "Film1", "Film2"));
        peopleRepo.put("Michal", new People("Michal", "Male", "Black", "Grey", "Film3", "Film2"));
        peopleRepo.put("Maria", new People("Maria", "Female", "Blue", "Black"));
    }

    @Override
    public List<People> all() {
        return (List<People>) peopleRepo.values().stream().collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public People search(String name) {
        return peopleRepo.get(name);
    }

    public People addFilm(String personName, String filmName) throws DBConnectionException {
        if (!SWUtils.isActive())
            throw new DBConnectionException("DB connection error");
        People people = peopleRepo.get(personName);
        people.getFilms().add(filmName);
        return people;
    }

}
