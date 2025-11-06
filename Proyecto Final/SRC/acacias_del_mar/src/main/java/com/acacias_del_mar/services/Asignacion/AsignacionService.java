package com.acacias_del_mar.services.Asignacion;

import com.acacias_del_mar.DTOs.AsignacionDTO;
import com.acacias_del_mar.entities.Asignacion;
import java.util.List;
import java.util.Optional;

public interface AsignacionService {
    List<Asignacion> obtenerTodas();
    Optional<Asignacion> obtenerPorId(Integer id);
    Asignacion crearAsignacion(AsignacionDTO asignacionDTO);
    Asignacion actualizarAsignacion(Integer id, AsignacionDTO asignacionDTO);
    void eliminarAsignacion(Integer id);
}
