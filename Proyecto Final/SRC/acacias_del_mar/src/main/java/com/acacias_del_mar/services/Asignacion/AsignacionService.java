package com.acacias_del_mar.services.Asignacion;

import com.acacias_del_mar.DTOs.AsignacionDTO;
import com.acacias_del_mar.entities.Asignacion;
import java.util.List;
import java.util.Optional;

public interface AsignacionService {
    List<AsignacionDTO> obtenerTodas();
    Optional<AsignacionDTO> obtenerPorId(Integer id);
    AsignacionDTO crearAsignacion(AsignacionDTO asignacionDTO);
    AsignacionDTO actualizarAsignacion(Integer id, AsignacionDTO asignacionDTO);
    void eliminarAsignacion(Integer id);
}
