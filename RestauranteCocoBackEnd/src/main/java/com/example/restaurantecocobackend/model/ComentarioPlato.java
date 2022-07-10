package com.example.restaurantecocobackend.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "tblComentario")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ComentarioPlato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  String descripcion;
    @ManyToOne
    @JoinColumn(name = "idPlato")
    private  Plato plato;
    private  Integer estrella;
    private  String fecha;
    @ManyToOne
    @JoinColumn(name = "idUse")
    private  Usuario use;
}
