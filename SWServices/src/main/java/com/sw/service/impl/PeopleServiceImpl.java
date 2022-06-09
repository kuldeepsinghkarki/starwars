package com.sw.service.impl;

import com.sw.data.PeopleRepository;
import com.sw.exceptions.DBConnectionException;
import com.sw.model.People;
import com.sw.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * People service implementation.
 */
@Service
public class PeopleServiceImpl extends BaseServiceImpl implements PeopleService {

    public static Queue<FilmRequests> filmAdditionRequests = new LinkedList<>();

    @Autowired
    PeopleRepository peopleRepository;

    @Override
    public List<People> getAll() {
        return peopleRepository.all();
    }

    @Override
    public People getByName(String name) {
        return peopleRepository.search(name);
    }


    @Override
    public People addFilm(String personName, String filName) throws DBConnectionException {
        People people = null;
        try {
            people = peopleRepository.addFilm(personName, filName);
        } catch (DBConnectionException e) {
            FilmRequests request = new FilmRequests(personName, filName);
            filmAdditionRequests.add(request);
            throw e;
        }
        return people;
    }

    @Override
    public boolean clearBufferRequests() throws DBConnectionException {
        if (filmAdditionRequests.isEmpty()) {
            return false;
        } else {
            for (FilmRequests request : filmAdditionRequests) {
                try {
                    peopleRepository.addFilm(request.personName, request.filmName);
                } catch (DBConnectionException e) {
                    throw e;
                }
            }
        }
        return true;
    }

}

class FilmRequests {

    String personName;

    String filmName;

    FilmRequests(String personName, String filmName) {
        this.personName = personName;
        this.filmName = filmName;
    }
}