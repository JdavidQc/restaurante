package com.example.restaurantecocobackend.repo;

import com.example.restaurantecocobackend.model.ComentarioPlato;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentRepor extends JpaRepository<ComentarioPlato,Integer> {

    List<ComentarioPlato> findAllByPlato_Id(Integer id);
}
