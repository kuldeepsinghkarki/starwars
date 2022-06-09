package com.sw.service;

import com.sw.exceptions.DBConnectionException;
import com.sw.model.People;

import java.util.List;

public interface PeopleService extends BaseService {

    public People getByName(String name);

    public List<People> getAll();

    public People addFilm(String personName, String name) throws DBConnectionException;

    public boolean clearBufferRequests() throws DBConnectionException;
}
