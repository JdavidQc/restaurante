package com.example.restaurantecocobackend.repo;

import com.example.restaurantecocobackend.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReserveRepor extends JpaRepository<Reserva,Integer> {



    List<Reserva> findAllByUse_Id(Integer id);
}
