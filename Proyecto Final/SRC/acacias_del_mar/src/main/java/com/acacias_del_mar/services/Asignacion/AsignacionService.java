package com.acacias_del_mar.services.Asignacion;

import com.acacias_del_mar.DTOs.AsignacionDTO;
import com.acacias_del_mar.DTOs.AsignacionResponseDTO;
import com.acacias_del_mar.entities.Asignacion;
import java.util.List;
import java.util.Optional;

public interface AsignacionService {
    List<AsignacionResponseDTO> obtenerTodas();
    Optional<AsignacionResponseDTO> obtenerPorId(Integer id);
    AsignacionResponseDTO crearAsignacion(AsignacionDTO asignacionDTO);
    AsignacionResponseDTO actualizarAsignacion(Integer id, AsignacionDTO asignacionDTO);
    void eliminarAsignacion(Integer id);
}
