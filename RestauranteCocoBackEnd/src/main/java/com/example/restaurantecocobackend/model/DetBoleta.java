package com.example.restaurantecocobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor(force = true)
@Table(name="tblDetBoleta")
@Getter
@Setter
public class DetBoleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idPlato")
    private Plato plato;
    private Integer cantidad;
    private double precio;
    private double  importePagar;
    @JsonBackReference
    @ManyToOne
    private CabBoleta detBoleta;
}
