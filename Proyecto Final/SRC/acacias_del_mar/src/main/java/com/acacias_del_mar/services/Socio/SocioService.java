package com.acacias_del_mar.services.Socio;


import com.acacias_del_mar.DTOs.SocioDTO;
import com.acacias_del_mar.entities.Socio;
import java.util.List;
import java.util.Optional;

public interface SocioService {
    List<Socio> obtenerTodosLosSocios();
    Optional<Socio> obtenerSocioPorId(Integer id);
    Socio crearSocio(SocioDTO socioDTO);
    Socio actualizarSocio(Integer id,SocioDTO socioDTO);
    void eliminarSocio(Integer id);
    
}
