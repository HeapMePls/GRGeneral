package com.um.lab.movix.movix.repos;

import com.um.lab.movix.movix.entities.MovieEmpr;
import com.um.lab.movix.movix.entities.MovieGenre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepo extends CrudRepository<MovieGenre,Integer> {
}
