package com.um.lab.movix.movix.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "movie_genres")
@Table(name = "movie_genres")
public class MovieGenres {
    @Id
    public int id;
    @Getter
    @Setter
    @Column(name = "movie_id")
    public int movie_id;
    @Getter
    @Setter
    @Column(name = "genre_id")
    public int genre_id;
}
