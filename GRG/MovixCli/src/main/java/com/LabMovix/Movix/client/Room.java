package com.LabMovix.Movix.client;
import com.LabMovix.Movix.client.RoomType;
import lombok.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Room {
    @Getter
    @Setter
    private int room_id;
    @Getter
    @Setter
    private int capacity;
    @Getter
    @Setter
   private String cinema;
    @Getter
    @Setter
    private String type;
    @Getter
    @Setter
    private String ubicacion;
    @Getter
    @Setter
    private int empr_id;
//    public Room(){}
}