package com.um.lab.movix.movix.repos;

import com.um.lab.movix.movix.entities.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RoomRepo extends CrudRepository<Room, Integer> {
    @Query("Select room from all_room_listing room where empr_id = ?1")
    List<Room> roomsFromCine(int emprId);

    @Query("Select room from all_room_listing room, moviefunction mf where mf.function_id = ?1 and mf.room_id = room.room_id")
    Room roomFromFuncion(int funid);
}



