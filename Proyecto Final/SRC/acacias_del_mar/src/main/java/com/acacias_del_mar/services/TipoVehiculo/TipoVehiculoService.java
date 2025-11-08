package com.acacias_del_mar.services.TipoVehiculo;

import com.acacias_del_mar.DTOs.TipoVehiculoDTO;
import com.acacias_del_mar.entities.TipoVehiculo;

import java.util.List;

public interface TipoVehiculoService {
    
    // Obtener todos los tipos de vehiculo
    List<TipoVehiculoDTO> obtenerTodos();
    
}
