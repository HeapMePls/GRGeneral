package com.LabMovix.Movix.client;


import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reserva {
    @Getter
    @Setter
    private int reserva_id;

    @Getter
    @Setter
    private int function_id;

    @Getter
    @Setter
    private String asientos;

    @Getter
    @Setter
    private int uid;

}