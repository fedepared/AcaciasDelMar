package com.acacias_del_mar.services.Vehiculo;

import com.acacias_del_mar.DTOs.VehiculoDTO;
import java.util.List;
import java.util.Optional;

public interface VehiculoService {
    List<VehiculoDTO> obtenerTodos();

    Optional<VehiculoDTO> obtenerPorId(Integer id);

    VehiculoDTO crearVehiculo(VehiculoDTO vehiculoDTO);

    VehiculoDTO actualizarVehiculo(Integer id, VehiculoDTO vehiculoDTO);

    void eliminarVehiculo(Integer id);
}
