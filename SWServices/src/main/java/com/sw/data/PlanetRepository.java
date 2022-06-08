package com.sw.data;

import com.sw.model.Planet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/**
 * Added planet repository using SPringBoot REST DATA
 */
public interface PlanetRepository extends CrudRepository<Planet,Long> {

    List<Planet> findByName(@Param("name") String name);
}
