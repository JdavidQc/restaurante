package com.example.restaurantecocobackend.repo;

import com.example.restaurantecocobackend.model.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepor extends JpaRepository<Plato,Integer> {
}
