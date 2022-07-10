package com.example.restaurantecocobackend.rest;

import com.example.restaurantecocobackend.model.CabBoleta;
import com.example.restaurantecocobackend.model.ComentarioPlato;
import com.example.restaurantecocobackend.model.DetBoleta;
import com.example.restaurantecocobackend.model.Usuario;
import com.example.restaurantecocobackend.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class Rest {

    private final PlatoRepor platoRepor;
    private final CabBoletaRepor cabBoletaRepor;
    private final DetBoletaRepor detBoletaRepor;
    private final UsuarioRepor usuarioRepor;

    @Autowired
    public Rest(PlatoRepor platoRepor,  CabBoletaRepor cabBoletaRepor, DetBoletaRepor detBoletaRepor, UsuarioRepor usuarioRepor) {
        this.platoRepor = platoRepor;
        this.cabBoletaRepor = cabBoletaRepor;
        this.detBoletaRepor = detBoletaRepor;
        this.usuarioRepor = usuarioRepor;
    }

    @RequestMapping(value = "/listPlato",method = RequestMethod.POST)
    public ResponseEntity<?>  listPlato()
    {
        return ResponseEntity.ok(platoRepor.findAll());
    }


    @RequestMapping(value = "/saveCab",method = RequestMethod.POST)
    public ResponseEntity<?>  saveCab(@RequestBody CabBoleta cabBoleta)
    {
        return ResponseEntity.ok(cabBoletaRepor.save(cabBoleta));
    }
    @RequestMapping(value = "/saveDet",method = RequestMethod.POST)
    public ResponseEntity<?>  saveDet(@RequestBody List<DetBoleta>  detBoletaList)
    {
        return ResponseEntity.ok(detBoletaRepor.saveAll(detBoletaList));
    }
    @RequestMapping(value = "/updatePunto",method = RequestMethod.POST)
    public ResponseEntity<?>  saveComentario(@RequestBody Usuario use)
    {
        Usuario u = usuarioRepor.findById(use.getId()).orElse(null);
        assert u != null;
        u.setPuntoActual(u.getPuntoActual() + (use.getPuntoActual()));
        return ResponseEntity.ok(usuarioRepor.save(u));
    }


}
