package com.acacias_del_mar.controllers.BackEnd;

import com.acacias_del_mar.DTOs.GarageDTO;
import com.acacias_del_mar.DTOs.VehiculoResponseDTO;
import com.acacias_del_mar.DTOs.VehiculoDTO;
import com.acacias_del_mar.entities.Garage;
import com.acacias_del_mar.services.Garage.GarageService;
import com.acacias_del_mar.services.Vehiculo.VehiculoService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {
    
    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'SOCIO')")
    public ResponseEntity<List<VehiculoResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(vehiculoService.obtenerTodos());
    }
    
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'SOCIO')")
    public ResponseEntity<VehiculoResponseDTO> obtenerPorId(@PathVariable Integer id) {
        return vehiculoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @PostMapping
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<?> crearVehiculo(@Valid @RequestBody VehiculoDTO vehiculoDTO) {
        try {
            VehiculoResponseDTO vehiculoCreado = vehiculoService.crearVehiculo(vehiculoDTO);
            return new ResponseEntity<>(vehiculoCreado, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<?> actualizarVehiculo(@PathVariable Integer id, @Valid @RequestBody VehiculoDTO vehiculoDTO) {
        try {
            VehiculoResponseDTO vehiculoActualizado = vehiculoService.actualizarVehiculo(id, vehiculoDTO);
            return ResponseEntity.ok(vehiculoActualizado);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<?> eliminarVehiculo(@PathVariable Integer id) {
        try {
            vehiculoService.eliminarVehiculo(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}



