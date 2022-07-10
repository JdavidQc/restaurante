package com.example.restaurantecocobackend.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tblCabBoleta")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CabBoleta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private  Usuario user;
    private  double ImporteTotal;
    private  String fechaGenerado;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "detBoleta")
    @ToString.Exclude
    private List<DetBoleta> detBoletas = new ArrayList<>();
}
