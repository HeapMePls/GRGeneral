package com.um.lab.movix.movix.entities;

import com.um.lab.movix.movix.enums.Genres;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "genres")
@Data
@Builder
@Table(name = "genres")
public class MovieGenre {

    @Id
    @Column(name = "genre_id")
    @Getter
    @Setter
    private int genre_id;

    @Getter
    @Setter
    private ArrayList<Movie> movie;


    @Column(name = "genre_tag")
    @Getter
    @Setter
//    @Enumerated(EnumType.STRING)
    private String genre_tag;
}
