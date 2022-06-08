package com.sw.service.impl;

import com.sw.data.PeopleRepository;
import com.sw.model.People;
import com.sw.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * People service implementation.
 */
@Service
public class PeopleServiceImpl extends BaseServiceImpl implements PeopleService {

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
}
