package com.acacias_del_mar.services.AsignacionZonaEmpleado;

import com.acacias_del_mar.DTOs.AsignacionEmpleadoZonaDTO;
import com.acacias_del_mar.entities.AsignacionEmpleadoZona;
import java.util.List;
import java.util.Optional;

public interface AsignacionEmpleadoZonaService {
    List<AsignacionEmpleadoZona> obtenerTodas();
    Optional<AsignacionEmpleadoZona> obtenerPorId(Integer id);
    AsignacionEmpleadoZona crearAsignacion(AsignacionEmpleadoZonaDTO dto);
    AsignacionEmpleadoZona actualizarAsignacion(Integer id,AsignacionEmpleadoZonaDTO dto);
    void eliminarAsignacion(Integer id);
}
