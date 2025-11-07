package com.acacias_del_mar.services.Socio;


import com.acacias_del_mar.DTOs.SocioDTO;
import com.acacias_del_mar.entities.Socio;
import java.util.List;
import java.util.Optional;

public interface SocioService {
    List<SocioDTO> obtenerTodosLosSocios();
    Optional<SocioDTO> obtenerSocioPorId(Integer id);
    SocioDTO crearSocio(SocioDTO socioDTO);
    SocioDTO actualizarSocio(Integer id,SocioDTO socioDTO);
    void eliminarSocio(Integer id);
    
}
