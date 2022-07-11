package com.example.restaurantecocobackend.rest;

import com.example.restaurantecocobackend.IdDto;
import com.example.restaurantecocobackend.dto.NumberDto;
import com.example.restaurantecocobackend.model.*;
import com.example.restaurantecocobackend.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class Rest {

    private final PlatoRepor platoRepor;
    private final ComentRepor comentoRepor;
    private final CabBoletaRepor cabBoletaRepor;
    private final DetBoletaRepor detBoletaRepor;
    private final UsuarioRepor usuarioRepor;
    private final ReserveRepor reserveRepor;
    @Autowired
    public Rest(PlatoRepor platoRepor, ComentRepor comentoRepor, CabBoletaRepor cabBoletaRepor, DetBoletaRepor detBoletaRepor, UsuarioRepor usuarioRepor, ReserveRepor reserveRepor) {
        this.platoRepor = platoRepor;
        this.comentoRepor = comentoRepor;
        this.cabBoletaRepor = cabBoletaRepor;
        this.detBoletaRepor = detBoletaRepor;
        this.usuarioRepor = usuarioRepor;
        this.reserveRepor = reserveRepor;
    }

    @RequestMapping(value = "/listPlato",method = RequestMethod.POST)
    public ResponseEntity<?>  listPlato()
    {
        return ResponseEntity.ok(platoRepor.findAll());
    }

    @RequestMapping(value = "/listPedido",method = RequestMethod.POST)
    public ResponseEntity<?>  listComentarioToPlato(@RequestBody NumberDto d)
    { return ResponseEntity.ok(cabBoletaRepor.findAllByUser_Id(d.getId())); }


    @RequestMapping(value = "/listComentario",method = RequestMethod.POST)
    public ResponseEntity<?>  listComentarioToPlato(@RequestBody IdDto idDto)
    {
        return ResponseEntity.ok(comentoRepor.findAllByPlato_Id(idDto.getId()));
    }

    @RequestMapping(value = "/saveComentario",method = RequestMethod.POST)
    public ResponseEntity<?>  saveComentario(@RequestBody ComentarioPlato comentario)
    {
        return ResponseEntity.ok(comentoRepor.save(comentario));
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
    @RequestMapping(value = "/saveReserva",method = RequestMethod.POST)
    public ResponseEntity<?>  saveReserva(@RequestBody Reserva s)
    {
        return ResponseEntity.ok(reserveRepor.save(s));
    }

    @RequestMapping(value = "/listReserva",method = RequestMethod.POST)
    public ResponseEntity<?>  listReserva(@RequestBody NumberDto d)
    {
        return ResponseEntity.ok(reserveRepor.findAllByUse_Id(d.getId()));
    }
    /*=======================================================================================*/

    @RequestMapping(value = "/point",method = RequestMethod.POST)
    public ResponseEntity<?>  getPoint(@RequestBody Usuario use)
    {
        Usuario u = usuarioRepor.findById(use.getId()).orElse(use);
        return ResponseEntity.ok(usuarioRepor.save(u));
    }
    @RequestMapping(value = "/updatePunto",method = RequestMethod.POST)
    public ResponseEntity<?>  saveComentario(@RequestBody Usuario use)
    {
        Usuario u = usuarioRepor.findById(use.getId()).orElse(null);
        assert u != null;
        u.setPuntoActual((Integer.parseInt(u.getPuntoActual()) + (Integer.parseInt(use.getPuntoActual()))+""));
        return ResponseEntity.ok(usuarioRepor.save(u));
    }


}
