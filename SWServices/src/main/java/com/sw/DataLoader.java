package com.sw;

import com.sw.data.PlanetRepository;
import com.sw.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class DataLoader implements CommandLineRunner {


    private final PlanetRepository repository;

    @Autowired
    public DataLoader(PlanetRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.repository.save(new Planet("Earth","Humid",1445L));
        this.repository.save(new Planet("Venus","Polar",123L));
    }
}
