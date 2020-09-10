package com.um.lab.movix.movix.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "movie_empr")
@Table(name = "movie_empr")
public class MovieEmpr {

    @Getter
    @Setter
    @Id
    @Column(name = "empr_id")
    private int empr_id;

    @Column(name = "empr_name")
    @Getter
    @Setter
    private String empr_name;

    @Column(name = "empr_locals")
    @Getter
    @Setter
    private String empr_locals;


}
