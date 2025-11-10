package com.acacias_del_mar.services.Socio;


import com.acacias_del_mar.DTOs.SocioDTO;
import com.acacias_del_mar.DTOs.SocioResponseDTO;
import com.acacias_del_mar.entities.Socio;
import java.util.List;
import java.util.Optional;

public interface SocioService {
    List<SocioResponseDTO> obtenerTodosLosSocios();
    Optional<SocioResponseDTO> obtenerSocioPorId(Integer id);
    SocioResponseDTO crearSocio(SocioDTO socioDTO);
    SocioResponseDTO actualizarSocio(Integer id,SocioDTO socioDTO);
    void eliminarSocio(Integer id);
    
}
