package com.LabMovix.Movix.client;


import javafx.beans.Observable;
import javafx.collections.FXCollections;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieFunction  {


    @Getter
    @Setter
    private int function_id ;

    @Getter
    @Setter
    private int movie_id ;

    @Getter
    @Setter
    private int empr_id ;

    @Getter
    @Setter
    private int room_id;

    @Getter
    @Setter
    private String schedule_time;

    @Getter
    @Setter
    private Date schedule_date;
}