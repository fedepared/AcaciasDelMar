package com.acacias_del_mar.controllers.BackEnd;

import com.acacias_del_mar.DTOs.AsignacionEmpleadoZonaDTO;
import com.acacias_del_mar.services.AsignacionZonaEmpleado.AsignacionEmpleadoZonaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones-empleado-zona")
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class AsignacionEmpleadoZonaRestController {

    @Autowired
    private AsignacionEmpleadoZonaService service;

    @GetMapping
    public ResponseEntity<List<AsignacionEmpleadoZonaDTO>> obtenerTodas() {
        return ResponseEntity.ok(service.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionEmpleadoZonaDTO> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearAsignacion(@Valid @RequestBody AsignacionEmpleadoZonaDTO dto) {
        try {
            AsignacionEmpleadoZonaDTO asignacionCreada = service.crearAsignacion(dto);
            return new ResponseEntity<>(asignacionCreada, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAsignacion(@PathVariable Integer id, @Valid @RequestBody AsignacionEmpleadoZonaDTO dto) {
        try {
            AsignacionEmpleadoZonaDTO asignacionActualizada = service.actualizarAsignacion(id, dto);
            return ResponseEntity.ok(asignacionActualizada);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAsignacion(@PathVariable Integer id) {
        try {
            service.eliminarAsignacion(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
