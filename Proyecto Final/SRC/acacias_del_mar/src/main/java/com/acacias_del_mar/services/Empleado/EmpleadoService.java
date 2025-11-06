package com.acacias_del_mar.services.Empleado;

import com.acacias_del_mar.DTOs.EmpleadoDTO;
import com.acacias_del_mar.entities.Empleado;
import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    List<Empleado> obtenerTodos();
    Optional<Empleado> obtenerPorId(Integer id);
    Empleado crearEmpleado(EmpleadoDTO empleadoDTO);
    Empleado actualizarEmpleado(Integer id,EmpleadoDTO empleadoDTO);
    void eliminarEmpleado(Integer id);
}
