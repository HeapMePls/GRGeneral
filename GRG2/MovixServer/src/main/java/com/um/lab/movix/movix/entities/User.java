package com.um.lab.movix.movix.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;


@Table(name = "usuario")
@Entity(name = "usuario")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Getter
    @Setter
    @Column(name = "uid")
    private int uid;
    @Getter
    @Setter
    @Column(name = "nombre")
    private String name;
    @Getter
    @Setter
    @Column(name = "email")
    private String email;
    @Getter
    @Setter
    @Column(name = "apellido")
    String apellido;
    @Getter
    @Setter
    @Column(name = "utype")
    private String utype;
    @Getter
    @Setter
    @Column(name = "pass")
    private String pass;
    @Getter
    @Setter
    @Column(name = "empr_name")
    private String empr_name;

}
