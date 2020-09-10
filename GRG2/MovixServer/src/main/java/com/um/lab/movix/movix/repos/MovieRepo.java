package com.um.lab.movix.movix.repos;

import com.um.lab.movix.movix.entities.Movie;
import com.um.lab.movix.movix.entities.MovieGenre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

public interface MovieRepo extends PagingAndSortingRepository<Movie, Integer> {
    @Query("SELECT a FROM all_movies_listing a WHERE UPPER(title) LIKE %?1%")
    List<Movie> findByTitle(String title);

//    @Query("SELECT genre_id INTO @genre FROM genres WHERE genre_tag = 'gen'; SELECT movie_id FROM movie_genre_relationship WHERE genre = @genre;")
//    List<Movie> findByGenreAndTitle(ArrayList<MovieGenre> genres);


//    List<Movie> findAllMovies(Pageable pageable);

    @Query("Select m From all_movies_listing m, genres g, movie_genres mg where m.movie_id = mg.movie_id and g.genre_id = mg.genre_id and UPPER(g.genre_tag) = UPPER(?1)")
    List<Movie> findByGenre(String genres);

}
