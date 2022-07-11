package com.example.restaurantecocobackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name="tblReserve")
@Entity
public class Reserva {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private  Integer id;
      private  String direccion;
      private  String fecha;
      private  String cantidad;
      private  String mesa;
      @ManyToOne
      @JoinColumn(name = "idUser")
      private  Usuario use;


}
