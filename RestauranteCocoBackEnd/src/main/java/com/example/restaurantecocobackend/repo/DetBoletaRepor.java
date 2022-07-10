package com.example.restaurantecocobackend.repo;

import com.example.restaurantecocobackend.model.DetBoleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetBoletaRepor extends JpaRepository<DetBoleta,Integer> {
}
