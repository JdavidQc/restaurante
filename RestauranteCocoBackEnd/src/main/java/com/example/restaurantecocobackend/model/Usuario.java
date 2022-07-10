package com.example.restaurantecocobackend.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "tblUsuario")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  String nombre;
    private  String puntoActual;
    private  String userName;
    private  String password;

}
