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
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class AsignacionesRestController {

    @Autowired
    private AsignacionService asignacionService;

    @GetMapping
    public ResponseEntity<List<Asignacion>> obtenerTodas() {
        return ResponseEntity.ok(asignacionService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignacion> obtenerPorId(@PathVariable Integer id) {
        return asignacionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearAsignacion(@Valid @RequestBody AsignacionDTO asignacionDTO) {
        try {
            Asignacion asignacionCreada = asignacionService.crearAsignacion(asignacionDTO);
            return new ResponseEntity<>(asignacionCreada, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAsignacion(@PathVariable Integer id, @Valid @RequestBody AsignacionDTO asignacionDTO) {
        try {
            Asignacion asignacionActualizada = asignacionService.actualizarAsignacion(id, asignacionDTO);
            return ResponseEntity.ok(asignacionActualizada);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAsignacion(@PathVariable Integer id) {
        try {
            asignacionService.eliminarAsignacion(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
}
