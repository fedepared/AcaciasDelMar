package com.acacias_del_mar.controllers.BackEnd;

import com.acacias_del_mar.DTOs.AsignacionDTO;
import com.acacias_del_mar.entities.Asignacion;
import com.acacias_del_mar.services.Asignacion.AsignacionService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/asignaciones")

public class AsignacionesRestController {

    @Autowired
    private AsignacionService asignacionService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'SOCIO')")
    public ResponseEntity<List<AsignacionDTO>> obtenerTodas() {
        return ResponseEntity.ok(asignacionService.obtenerTodas());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'SOCIO')")
    public ResponseEntity<AsignacionDTO> obtenerPorId(@PathVariable Integer id) {
        return asignacionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<?> crearAsignacion(@Valid @RequestBody AsignacionDTO asignacionDTO) {
        try {
            AsignacionDTO asignacionCreada = asignacionService.crearAsignacion(asignacionDTO);
            return new ResponseEntity<>(asignacionCreada, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<?> actualizarAsignacion(@PathVariable Integer id, @Valid @RequestBody AsignacionDTO asignacionDTO) {
        try {
            AsignacionDTO asignacionActualizada = asignacionService.actualizarAsignacion(id, asignacionDTO);
            return ResponseEntity.ok(asignacionActualizada);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<?> eliminarAsignacion(@PathVariable Integer id) {
        try {
            asignacionService.eliminarAsignacion(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
}
