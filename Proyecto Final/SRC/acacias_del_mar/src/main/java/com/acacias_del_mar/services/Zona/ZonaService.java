package com.acacias_del_mar.services.Zona;

import com.acacias_del_mar.DTOs.ZonaDTO;
import com.acacias_del_mar.entities.Zona;
import java.util.List;
import java.util.Optional;


public interface ZonaService{
    List<Zona> obtenerZonas();
    
    Zona crearZona(ZonaDTO zonaDTO);
    
    Optional<Zona> obtenerPorId(Integer id);
    
    Zona actualizarZona(Integer id, ZonaDTO zonaDTO);
    
    void eliminarZona(Integer id);
}
