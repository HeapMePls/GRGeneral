package com.um.lab.movix.movix.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "reserva")
@Table(name = "reserva")
public class Reserva {
    @Getter
    @Setter
    @Id
    @Column(name = "reserva_id")
    private int reserva_id;

    @Column(name = "function_id")
    @Getter
    @Setter
    private int function_id;
    @Column(name = "uid")
    @Getter
    @Setter
    private int uid;

    @Column(name = "asientos")
    @Getter
    @Setter
    private String asientos;
}
