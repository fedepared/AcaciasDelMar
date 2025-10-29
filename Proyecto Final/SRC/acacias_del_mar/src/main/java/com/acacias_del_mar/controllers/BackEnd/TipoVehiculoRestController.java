package com.acacias_del_mar.controllers.BackEnd;

import com.acacias_del_mar.entities.TipoVehiculo;
import com.acacias_del_mar.services.TipoVehiculo.TipoVehiculoService;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("/api/tipoVehiculos")
@CrossOrigin(origins = "*")
@Slf4j
public class TipoVehiculoRestController {
    
    @Autowired
    private TipoVehiculoService tvService;
    
    //Get
    @GetMapping
    public ResponseEntity<List<TipoVehiculo>> obtenerTodos()
    {
        log.info("GET /api/tipoVehiculos - obtener todos los tipos de vehiculos");
        List<TipoVehiculo> tvs = tvService.obtenerTiposDeVehiculo();
        return ResponseEntity.ok(tvs);
    }
    
    
}

