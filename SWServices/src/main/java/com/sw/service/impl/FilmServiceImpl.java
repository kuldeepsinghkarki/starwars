package com.sw.service.impl;

import com.sw.data.FilmRepository;
import com.sw.model.Film;
import com.sw.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    FilmRepository filmRepository;


    @Override
    public Film getByName(String name) {
        return filmRepository.search(name);
    }

    @Override
    public List<Film> getAll() {
        return filmRepository.all();
    }
}
