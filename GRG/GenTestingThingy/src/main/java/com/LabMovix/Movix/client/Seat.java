package com.LabMovix.Movix.client;

import javafx.scene.image.ImageView;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Seat {
    @Getter
    @Setter
    private ImageView image;
    @Getter
    @Setter
    private int state;
    @Getter
    @Setter
    private String pos;


}
