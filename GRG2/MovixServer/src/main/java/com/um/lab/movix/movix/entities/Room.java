package com.um.lab.movix.movix.entities;

import com.um.lab.movix.movix.enums.RoomType;
import lombok.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "all_room_listing")
public class Room {
    @Getter
    @Setter
    @Id
    @Column(name = "room_id")
    private int room_id;
    @Column(name = "capacity")
    @Getter
    @Setter
    private int capacity;
    @Column(name = "room_type")
    @Getter
    @Setter
    private String type;
    @Column(name = "empr_id")
    @Getter
    @Setter
    private int empr_id;

//    public Room(){}
}
