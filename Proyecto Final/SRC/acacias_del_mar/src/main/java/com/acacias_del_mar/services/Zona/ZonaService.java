package com.acacias_del_mar.services.Zona;

import com.acacias_del_mar.DTOs.ZonaDTO;
import com.acacias_del_mar.DTOs.ZonaResponseDTO;
import com.acacias_del_mar.entities.Zona;
import java.util.List;
import java.util.Optional;


public interface ZonaService{
    List<ZonaResponseDTO> obtenerTodas();
    
    Optional<ZonaResponseDTO> obtenerPorId(Integer id);
    
    ZonaResponseDTO crearZona(ZonaDTO zonaDTO);
    
    ZonaResponseDTO actualizarZona(Integer id, ZonaDTO zonaDTO);
    
    void eliminarZona(Integer id);
}
