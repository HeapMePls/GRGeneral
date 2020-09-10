package com.LabMovix.Movix.client;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    @Getter
    @Setter
    private int movie_id;

    @Getter
    @Setter
    @JsonProperty("movieName")
    private String title;
    @Getter
    @Setter
    @JsonProperty("movieDescription")
    private String description;
    @Getter
    @Setter
    @JsonProperty("movieDuracion")
    private String duration;
    @Getter
    @Setter
    @JsonProperty("moviePublishDate")
    private Date publishDate;
    @Getter
    @Setter
    @JsonProperty("moviePublishLimit")
    private Date publishLimit;
    @Getter
    @Setter
    @JsonProperty("movieActores")
    private String actors;
    @Getter
    @Setter
    @JsonProperty("movieDirector")
    private String director;
    @Getter
    @Setter
    private Date releaseDate;
    @Getter
    @Setter
    @JsonProperty("movieEdadMin")
    private String minAge;
    @Getter
    @Setter
    @JsonProperty("movieImage")
    @JsonAlias("movieImage")
    private byte[] icon;
    @Getter
    @Setter
    @JsonProperty("movieGenero")
    private Collection<MovieGenre> genre;

    @Getter
    @Setter

    private String trailer;


}