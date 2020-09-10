package com.um.lab.movix.movix.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "all_movies_listing")
@Table(name = "all_movies_listing")
public class Movie {
    @Getter
    @Setter
    @Id
    @Column(name = "movie_id")
    private int movie_id;
    @Column(name = "title")
    @Getter
    @Setter
    @JsonProperty("movieName")
    private String title;
    @Getter
    @Setter
    @JsonProperty("movieDescription")
    @Column(name = "description")
    private String description;
    @Getter
    @Setter
    @JsonProperty("movieDuracion")
    @Column(name = "duration")
    private String duration;
    @Getter
    @Setter
    @JsonProperty("moviePublishDate")
    @Column(name = "publishdate")
    private Date publishdate;
    @Getter
    @Setter
    @JsonProperty("moviePublishLimit")
    @Column(name = "publish_limit")
    private Date publish_limit;
    @Getter
    @Setter
    @Column(name = "actors")
    @JsonProperty("movieActores")
    private String actors;
    @JsonProperty("movieDirector")
    @Getter
    @Setter
    @Column(name = "director")
    private String director;
    @JsonProperty("trailer")
    @Getter
    @Setter
    @Column(name = "trailer")
    private String trailer;
    @Getter
    @Setter
    @Column(name = "releaseDate")
    private Date releaseDate;
    @Getter
    @Setter
    @JsonProperty("movieEdadMin")
    @Column(name = "minAge")
    private String minAge;
    @Getter
    @Setter
    @JsonProperty("movieImage")
    @Column(name = "icon")
    @Lob
    private byte[] icon;
    @Getter
    @Setter
    @JsonProperty("movieGenero")
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Collection<MovieGenre> genre;
}
