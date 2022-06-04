package com.sw.data;

import com.sw.model.Film;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class FilmRepository implements SwRepository {

    private static Map<String, Film> filmRepo = new HashMap<>();

    static {
        filmRepo.put("Film1", new Film("Film1", 12, "Producer1"));
        filmRepo.put("Film2", new Film("Film2", 32, "Producer2"));
        filmRepo.put("Film3", new Film("Film3", 52, "Producer3"));
        filmRepo.put("Film4", new Film("Film4", 22, "Producer4"));

    }


    @Override
    public List all() {
        return (List<Film>) filmRepo.values().stream().collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Film search(String name) {
        return filmRepo.get(name);
    }
}
