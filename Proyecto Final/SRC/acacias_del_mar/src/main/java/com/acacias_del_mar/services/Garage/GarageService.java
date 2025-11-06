package com.acacias_del_mar.services.Garage;

import com.acacias_del_mar.DTOs.GarageDTO;
import com.acacias_del_mar.entities.Garage;
import java.util.List;
import java.util.Optional;

public interface GarageService {
    List<Garage> obtenerTodos();
    Optional<Garage> obtenerPorId(Integer id);
    Garage crearGarage(GarageDTO garageDTO);
    Garage actualizarGarage(Integer id, GarageDTO garageDTO);
    void eliminarGarage(Integer id);
}