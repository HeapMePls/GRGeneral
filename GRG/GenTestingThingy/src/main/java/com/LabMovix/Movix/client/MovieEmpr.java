package com.LabMovix.Movix.client;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieEmpr {

    @Getter
    @Setter
    private int empr_id;

    @Getter
    @Setter
    private String empr_name;

    @Getter
    @Setter
    private String empr_locals;


}