package com.um.lab.movix.movix.repos;

import com.um.lab.movix.movix.entities.Reserva;
import com.um.lab.movix.movix.entities.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservaRepo extends CrudRepository<Reserva,Integer> {

    @Query("Select r from reserva r where function_id = ?1")
    List<Reserva> reservasDeFuncion (int functionID);
    @Query("Select r from reserva r, usuario u where r.uid = u.uid and u.email = ?1")
    List<Reserva> reservasPorUsuario (String email);
    @Query("Select r from reserva r , moviefunction f , movie_empr e where r.function_id = f.function_id and e.empr_id = f.empr_id and UPPER(e.empr_name) Like(?1)")
    List<Reserva> reservasPorCine(String cine);
}
