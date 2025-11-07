package com.acacias_del_mar.controllers.BackEnd;

import com.acacias_del_mar.DTOs.SocioDTO;
import com.acacias_del_mar.entities.Socio;
import com.acacias_del_mar.services.Socio.SocioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/socios")
@PreAuthorize("hasRole('ADMINISTRADOR')")

public class SocioRestController {
    @Autowired
    private SocioService socioService;
    
    @GetMapping
    public ResponseEntity<List<SocioDTO>> obtenerTodos(){
        return ResponseEntity.ok(socioService.obtenerTodosLosSocios());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SocioDTO> obtenerPorId(@PathVariable Integer id)
    {
        return socioService.obtenerSocioPorId(id)
                .map(socio -> ResponseEntity.ok(socio))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<?> crearSocio(@Valid @RequestBody SocioDTO socioDTO)
    {
        try{
            SocioDTO socioCreado = socioService.crearSocio(socioDTO);
            return new ResponseEntity<>(socioCreado, HttpStatus.CREATED);
        }catch(RuntimeException e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarSocio(@PathVariable Integer id, @Valid @RequestBody SocioDTO socioDTO)
    {
        try{
            SocioDTO socioActualizado = socioService.actualizarSocio(id, socioDTO);
            return ResponseEntity.ok(socioActualizado);
        }catch(RuntimeException e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarSocio(@PathVariable Integer id)
    {
        try{
            socioService.eliminarSocio(id);
            return ResponseEntity.noContent().build();
        }catch(RuntimeException e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
