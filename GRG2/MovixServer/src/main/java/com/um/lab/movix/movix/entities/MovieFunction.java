package com.um.lab.movix.movix.entities;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "moviefunction")
@Table(name = "moviefunction")
public class MovieFunction {

    @Getter
    @Setter
    @Id
    @Column(name = "function_id")
    private int function_id ;

    @Column(name = "movie_id")
    @Getter
    @Setter
    private int movie_id ;

    @Column(name = "empr_id")
    @Getter
    @Setter
    private int empr_id ;

    @Getter
    @Setter
    @Column(name = "schedule_date")
    private Date schedule_date;

    @Column(name = "room_id")
    @Getter
    @Setter
    private int room_id;

    @Column(name = "schedule_time")
    @Getter
    @Setter
    private String schedule_time;
}
