package com.example.restaurantecocobackend.repo;

import com.example.restaurantecocobackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepor extends JpaRepository<Usuario,Integer> {
}
