package com.example.restaurantecocobackend.rest;

import com.example.restaurantecocobackend.repo.PlatoRepor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class Rest {

    private final PlatoRepor platoRepor;

    public Rest(PlatoRepor platoRepor) {
        this.platoRepor = platoRepor;
    }

    @RequestMapping(value = "/listPlato",method = RequestMethod.GET)
    public ResponseEntity<?>  listPlato()
    {
        return ResponseEntity.ok(platoRepor.findAll());
    }

}
