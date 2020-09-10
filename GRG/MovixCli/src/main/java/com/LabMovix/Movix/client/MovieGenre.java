package com.LabMovix.Movix.client;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieGenre {

    @Getter
    @Setter
    private int genre_id;

    @Getter
    @Setter
    private ArrayList<Movie> movie;


    @Getter
    @Setter
//    @Enumerated(EnumType.STRING)
    private String genre_tag;
}