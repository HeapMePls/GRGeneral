package com.um.lab.movix.movix.repos;

import com.um.lab.movix.movix.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User,Integer> {
    @Query("Select u from usuario u where  email = ?1 and pass = ?2")
    List<User> loguserIn (String email , String pass);
}
