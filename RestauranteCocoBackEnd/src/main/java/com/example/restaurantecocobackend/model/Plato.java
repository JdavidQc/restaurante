package com.example.restaurantecocobackend.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tblPlato")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Plato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private double precio;
    private Integer disponibilidad;
    private Integer  punto;
    private Integer tipo;
    private String foto;


}
