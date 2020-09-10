package com.um.lab.movix.movix.utils;

import com.um.lab.movix.movix.entities.MovieGenre;
import com.um.lab.movix.movix.enums.Genres;
import com.um.lab.movix.movix.enums.RoomType;

import java.util.ArrayList;

public class Utils {
    public static Genres string_To_MovieGenre(String gen) {
        if (gen.toLowerCase() == "thriller") return Genres.Thriller;
        else if (gen.toLowerCase() == "animated") return Genres.Animated;
        else if (gen.toLowerCase() == "cartoon") return Genres.Cartoon;
        else if (gen.toLowerCase() == "comic") return Genres.Comic;
        else if (gen.toLowerCase() == "suspense") return Genres.Suspense;
        else return Genres.Non_Clasified;

    }

    public static RoomType string_To_RoomType(String type) {
        if (type.toLowerCase() == "2d") return RoomType.Cinema2D;
        else if (type.toLowerCase() == "3d") return RoomType.Cinema3D;
        else if (type.toLowerCase() == "4d") return RoomType.Cinema4D;
        else if (type.toLowerCase() == "theater") return RoomType.Theater;
        else return RoomType.Cinema2D;

    }

    public static ArrayList<MovieGenre> movieGenreToArr(String movieGenres) {
        String[] lista = movieGenres.split(",");
        ArrayList<MovieGenre> ret = new ArrayList<>();
        for(String genreString : lista) {

//            Genres genere = string_To_MovieGenre(genreString);
            MovieGenre mg = MovieGenre.builder().genre_tag(genreString).build();
            ret.add(mg);
        }
        return ret;
    }
}
