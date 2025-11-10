package com.acacias_del_mar.services.Garage;

import com.acacias_del_mar.DTOs.GarageDTO;
import com.acacias_del_mar.DTOs.GarageResponseDTO;
import com.acacias_del_mar.entities.Garage;
import java.util.List;
import java.util.Optional;

public interface GarageService {
    List<GarageResponseDTO> obtenerTodos();
    Optional<GarageResponseDTO> obtenerPorId(Integer id);
    GarageResponseDTO crearGarage(GarageDTO garageDTO);
    GarageResponseDTO actualizarGarage(Integer id, GarageDTO garageDTO);
    void eliminarGarage(Integer id);
}