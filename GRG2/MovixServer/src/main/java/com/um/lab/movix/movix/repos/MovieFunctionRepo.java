package com.um.lab.movix.movix.repos;

import com.um.lab.movix.movix.entities.MovieEmpr;
import com.um.lab.movix.movix.entities.MovieFunction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface MovieFunctionRepo extends CrudRepository<MovieFunction, Integer> {
    @Query("SELECT mf FROM all_movies_listing a, moviefunction mf  WHERE   a.movie_id = ?1 and mf.movie_id = a.movie_id")
    List<MovieFunction> findById(int movieid);

    @Query("SELECT empr from movie_empr empr, all_movies_listing p, moviefunction f where p.movie_id= ?1 and UPPER(empr.empr_name)= UPPER(?3) and f.movie_id =p.movie_id and f.empr_id =empr.empr_id and ?2 between p.publishdate and publish_limit")
    List<MovieEmpr> localesEnCinePeliculaDia(int movieid, Date dia, String nombreCine);

    @Query("SELECT f from movie_empr empr, all_movies_listing p, moviefunction f where p.movie_id= ?1 and UPPER(empr.empr_name)= UPPER(?3) and UPPER(empr.empr_locals)= UPPER(?4)  and f.movie_id =p.movie_id and f.empr_id =empr.empr_id and ?2 = f.schedule_date")
    List<MovieFunction> horariosEnDia_CineYlocal(int movieid, Date dia, String nombreCine, String nombre_local);
}