package com.acacias_del_mar.controllers.BackEnd;

import com.acacias_del_mar.DTOs.TipoVehiculoDTO;
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
import org.springframework.security.access.prepost.PreAuthorize;



@RestController
@RequestMapping("/api/tipos-vehiculo")
// Permitimos que ADMIN (para el CRUD) y SOCIO (para ver) accedan
@PreAuthorize("hasAnyRole('ADMINISTRADOR', 'SOCIO')")
public class TipoVehiculoRestController {

    @Autowired
    private TipoVehiculoService tipoVehiculoService;

    @GetMapping
    public ResponseEntity<List<TipoVehiculoDTO>> obtenerTodos() {
        return ResponseEntity.ok(tipoVehiculoService.obtenerTodos());
    }
}

