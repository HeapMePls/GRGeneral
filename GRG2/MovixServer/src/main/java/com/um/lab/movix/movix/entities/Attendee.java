package com.um.lab.movix.movix.entities;

import lombok.Builder;

import javax.persistence.Entity;


@Builder
//@Entity
public class Attendee {
    private User user;

}
