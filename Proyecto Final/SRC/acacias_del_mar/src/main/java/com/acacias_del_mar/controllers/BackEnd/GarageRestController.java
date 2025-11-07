package com.acacias_del_mar.controllers.BackEnd;

import com.acacias_del_mar.DTOs.GarageDTO;
import com.acacias_del_mar.entities.Garage;
import com.acacias_del_mar.services.Garage.GarageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garages")
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class GarageRestController {

    @Autowired
    private GarageService garageService;

    @GetMapping
    public ResponseEntity<List<GarageDTO>> obtenerTodos() {
        return ResponseEntity.ok(garageService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GarageDTO> obtenerPorId(@PathVariable Integer id) {
        return garageService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearGarage(@Valid @RequestBody GarageDTO garageDTO) {
        try {
            GarageDTO garageCreado = garageService.crearGarage(garageDTO);
            return new ResponseEntity<>(garageCreado, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarGarage(@PathVariable Integer id, @Valid @RequestBody GarageDTO garageDTO) {
        try {
            GarageDTO garageActualizado = garageService.actualizarGarage(id, garageDTO);
            return ResponseEntity.ok(garageActualizado);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarGarage(@PathVariable Integer id) {
        try {
            garageService.eliminarGarage(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            // Podría ser NOT_FOUND o CONFLICT (si no se puede borrar por FK)
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}