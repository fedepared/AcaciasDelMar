package com.acacias_del_mar.services.Empleado;

import com.acacias_del_mar.DTOs.EmpleadoDTO;
import com.acacias_del_mar.DTOs.EmpleadoResponseDTO;
import com.acacias_del_mar.entities.Empleado;
import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    List<EmpleadoResponseDTO> obtenerTodos();
    Optional<EmpleadoResponseDTO> obtenerPorId(Integer id);
    EmpleadoResponseDTO crearEmpleado(EmpleadoDTO empleadoDTO);
    EmpleadoResponseDTO actualizarEmpleado(Integer id,EmpleadoDTO empleadoDTO);
    void eliminarEmpleado(Integer id);
}
