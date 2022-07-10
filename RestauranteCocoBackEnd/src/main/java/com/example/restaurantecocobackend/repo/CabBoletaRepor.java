package com.example.restaurantecocobackend.repo;

import com.example.restaurantecocobackend.model.CabBoleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabBoletaRepor extends JpaRepository<CabBoleta,Integer> {
}
