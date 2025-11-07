package com.acacias_del_mar.controllers.BackEnd;

import com.acacias_del_mar.DTOs.CompraGarageDTO;
import com.acacias_del_mar.entities.CompraGarage;
import com.acacias_del_mar.services.CompraGarage.CompraGarageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compra-garage")
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class CompraGarageRestController {
    @Autowired
    private CompraGarageService service;

    @GetMapping
    public ResponseEntity<List<CompraGarageDTO>> obtenerTodas() {
        return ResponseEntity.ok(service.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraGarageDTO> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearCompraGarage(@Valid @RequestBody CompraGarageDTO dto) {
        try {
            CompraGarageDTO compraCreada = service.crearCompraGarage(dto);
            return new ResponseEntity<>(compraCreada, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCompraGarage(@PathVariable Integer id, @Valid @RequestBody CompraGarageDTO dto) {
        try {
            CompraGarageDTO compraActualizada = service.actualizarCompraGarage(id, dto);
            return ResponseEntity.ok(compraActualizada);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCompraGarage(@PathVariable Integer id) {
        try {
            service.eliminarCompraGarage(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
