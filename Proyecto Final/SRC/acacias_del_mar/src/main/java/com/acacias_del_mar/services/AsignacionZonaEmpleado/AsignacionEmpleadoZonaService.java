package com.acacias_del_mar.services.AsignacionZonaEmpleado;

import com.acacias_del_mar.DTOs.AsignacionEmpleadoZonaDTO;
import com.acacias_del_mar.entities.AsignacionEmpleadoZona;
import java.util.List;
import java.util.Optional;

public interface AsignacionEmpleadoZonaService {
    List<AsignacionEmpleadoZonaDTO> obtenerTodas();
    Optional<AsignacionEmpleadoZonaDTO> obtenerPorId(Integer id);
    AsignacionEmpleadoZonaDTO crearAsignacion(AsignacionEmpleadoZonaDTO dto);
    AsignacionEmpleadoZonaDTO actualizarAsignacion(Integer id,AsignacionEmpleadoZonaDTO dto);
    void eliminarAsignacion(Integer id);
}
