package com.acacias_del_mar.controllers.BackEnd;

import com.acacias_del_mar.DTOs.ZonaDTO;
import com.acacias_del_mar.DTOs.ZonaResponseDTO;
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
@RequestMapping("/api/zonas")
@PreAuthorize("hasRole('ADMINISTRADOR')")
@CrossOrigin(origins = "*")
@Slf4j
public class ZonaRestController {
    @Autowired 
    private ZonaService zonaService;
    
    
    @PostMapping
    public ResponseEntity<ZonaResponseDTO> crearZona(@Valid @RequestBody ZonaDTO zonaDTO){
        ZonaResponseDTO zonaCreada = zonaService.crearZona(zonaDTO);
        
        return new ResponseEntity<>(zonaCreada, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<ZonaResponseDTO>> obtenerTodasLasZonas() {
        List<ZonaResponseDTO> zonas = zonaService.obtenerTodas(); 
        return ResponseEntity.ok(zonas);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<ZonaResponseDTO> obtenerZonaPorId(@PathVariable Integer id) {
        return zonaService.obtenerPorId(id) 
                .map(zona -> ResponseEntity.ok(zona))
                .orElse(ResponseEntity.notFound().build()); 
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<ZonaResponseDTO> actualizarZona(@PathVariable Integer id, 
                                             @Valid @RequestBody ZonaDTO zonaDTO) {
        try {
    
            ZonaResponseDTO zonaActualizada = zonaService.actualizarZona(id, zonaDTO); 
            return ResponseEntity.ok(zonaActualizada);
        } catch (RuntimeException e) {
    
            return ResponseEntity.notFound().build();
        }
    }

    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarZona(@PathVariable Integer id) {
        try {
            zonaService.eliminarZona(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
 
            return ResponseEntity.notFound().build();
        }
    }

 
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
 
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
}