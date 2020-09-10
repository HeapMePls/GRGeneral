package com.um.lab.movix.movix.entities;

import lombok.Builder;

import javax.persistence.Entity;
//import org.hibernate.annotations.Entity;

@Builder
//@Entity
public class Publication {
    private Movie movie;
    private String time;
    private Room room;
}
