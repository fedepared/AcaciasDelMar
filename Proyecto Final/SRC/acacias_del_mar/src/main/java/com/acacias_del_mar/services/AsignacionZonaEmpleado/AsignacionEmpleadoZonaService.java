package com.acacias_del_mar.services.AsignacionZonaEmpleado;

import com.acacias_del_mar.DTOs.AsignacionEmpleadoZonaDTO;
import com.acacias_del_mar.DTOs.AsignacionEmpleadoZonaResponseDTO;
import com.acacias_del_mar.entities.AsignacionEmpleadoZona;
import java.util.List;
import java.util.Optional;

public interface AsignacionEmpleadoZonaService {
    List<AsignacionEmpleadoZonaResponseDTO> obtenerTodas();
    Optional<AsignacionEmpleadoZonaResponseDTO> obtenerPorId(Integer id);
    AsignacionEmpleadoZonaResponseDTO crearAsignacion(AsignacionEmpleadoZonaDTO dto);
    AsignacionEmpleadoZonaResponseDTO actualizarAsignacion(Integer id,AsignacionEmpleadoZonaDTO dto);
    void eliminarAsignacion(Integer id);
}
