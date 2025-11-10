package com.acacias_del_mar.controllers.BackEnd;

import com.acacias_del_mar.DTOs.EmpleadoDTO;
import com.acacias_del_mar.DTOs.EmpleadoResponseDTO;
import com.acacias_del_mar.entities.Empleado;
import com.acacias_del_mar.services.Empleado.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class EmpleadoRestController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMINISTRADOR','SOCIO','EMPLEADO')")
    public ResponseEntity<List<EmpleadoResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(empleadoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR','SOCIO','EMPLEADO')")
    public ResponseEntity<EmpleadoResponseDTO> obtenerPorId(@PathVariable Integer id) {
        return empleadoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<?> crearEmpleado(@Valid @RequestBody EmpleadoDTO empleadoDTO) {
        try {
            EmpleadoResponseDTO empleadoCreado = empleadoService.crearEmpleado(empleadoDTO);
            return new ResponseEntity<>(empleadoCreado, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<?> actualizarEmpleado(@PathVariable Integer id, @Valid @RequestBody EmpleadoDTO empleadoDTO) {
        try {
            EmpleadoResponseDTO empleadoActualizado = empleadoService.actualizarEmpleado(id, empleadoDTO);
            return ResponseEntity.ok(empleadoActualizado);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<?> eliminarEmpleado(@PathVariable Integer id) {
        try {
            empleadoService.eliminarEmpleado(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
