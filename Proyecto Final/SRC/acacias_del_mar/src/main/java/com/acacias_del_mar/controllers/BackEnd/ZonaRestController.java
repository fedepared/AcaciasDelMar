package com.acacias_del_mar.controllers.BackEnd;

import com.acacias_del_mar.DTOs.ZonaDTO;
import com.acacias_del_mar.entities.Zona;
import com.acacias_del_mar.services.Zona.ZonaService;
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
@RequestMapping("/api/zona")
@PreAuthorize("hasRole('ADMINISTRADOR')")
@CrossOrigin(origins = "*")
@Slf4j
public class ZonaRestController {
    @Autowired 
    private ZonaService zonaService;
    
    //Post
    @PostMapping
    public ResponseEntity<Zona> crearZona(@Valid @RequestBody ZonaDTO zonaDTO){
        Zona zonaCreada = zonaService.crearZona(zonaDTO);
        
        return new ResponseEntity<>(zonaCreada, HttpStatus.CREATED);
    }
    /**
     * GET /api/zonas
     * Obtiene una lista de todas las zonas.
     */
    @GetMapping
    public ResponseEntity<List<Zona>> obtenerTodasLasZonas() {
        List<Zona> zonas = zonaService.obtenerZonas(); // Asumo que tienes este método
        return ResponseEntity.ok(zonas);
    }

    /**
     * GET /api/zonas/{id}
     * Obtiene una zona específica por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Zona> obtenerZonaPorId(@PathVariable Integer id) {
        // Asumo un método que devuelve Optional<Zona>
        return zonaService.obtenerPorId(id) 
                .map(zona -> ResponseEntity.ok(zona)) // Si se encuentra, 200 OK
                .orElse(ResponseEntity.notFound().build()); // Si no, 404 Not Found
    }

    /**
     * PUT /api/zonas/{id}
     * Actualiza una zona existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Zona> actualizarZona(@PathVariable Integer id, 
                                             @Valid @RequestBody ZonaDTO zonaDTO) {
        try {
            // Asumo un servicio que toma el ID y el DTO para actualizar
            Zona zonaActualizada = zonaService.actualizarZona(id, zonaDTO); 
            return ResponseEntity.ok(zonaActualizada);
        } catch (RuntimeException e) {
            // Maneja el caso de que el ID de la zona no se encuentre
            return ResponseEntity.notFound().build();
        }
    }

    
    /**
     * DELETE /api/zonas/{id}
     * Elimina una zona por su ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarZona(@PathVariable Integer id) {
        try {
            zonaService.eliminarZona(id); // Asumo que tienes este método
            return ResponseEntity.noContent().build(); // 204 No Content (éxito sin respuesta)
        } catch (RuntimeException e) {
            // Maneja el caso de que el ID no se encuentre
            return ResponseEntity.notFound().build();
        }
    }

    //esto agarra cualquier RunTimeException
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        // Devuelve un 400 Bad Request + el mensaje de la excepción
        // ej: "Error: la letra ya existe"
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
}