package com.um.lab.movix.movix.entities;

import lombok.Builder;

import javax.persistence.Entity;
import java.util.ArrayList;
//@Entity
@Builder
public class Cinema {
    private String name;
    private String location;
//    Array list, It won't be a huge number of rooms on each cinema
    private ArrayList<Room> rooms;

}
