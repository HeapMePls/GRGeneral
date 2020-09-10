package com.um.lab.movix.movix.repos;

import com.um.lab.movix.movix.entities.Movie;
import com.um.lab.movix.movix.entities.MovieEmpr;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface MovieEmprRepo extends CrudRepository<MovieEmpr,Integer> {
    @Query("SELECT mf FROM all_movies_listing a, moviefunction mf  WHERE   a.movie_id = ?1 and mf.movie_id = a.movie_id")
    List<MovieEmpr> findByTitle(int movieid);

    @Query("SELECT empr from movie_empr empr, all_movies_listing p, moviefunction f where p.movie_id= ?1 and UPPER(empr.empr_name)= UPPER(?3) and f.movie_id =p.movie_id and f.empr_id =empr.empr_id and ?2 between p.publishdate and publish_limit")
    List<MovieEmpr> findLocals(int movieid, Date dia,String empr_name);
    @Query("SELECT empr from movie_empr empr , usuario u where UPPER(empr.empr_name)= UPPER(u.empr_name) and UPPER(empr.empr_name)= UPPER(?1) ")
    List<MovieEmpr> findLocalesEmpr(String empr_name);
}
