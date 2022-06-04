package com.sw.service;

import com.sw.model.Film;

import java.util.List;

public interface FilmService extends BaseService {
    public Film getByName(String name);

    public List<Film> getAll();
}
