package com.acacias_del_mar.services.CompraGarage;

import com.acacias_del_mar.DTOs.CompraGarageDTO;
import com.acacias_del_mar.DTOs.CompraGarageResponseDTO;
import com.acacias_del_mar.entities.CompraGarage;
import java.util.List;
import java.util.Optional;

public interface CompraGarageService {
    List<CompraGarageResponseDTO> obtenerTodas();
    Optional<CompraGarageResponseDTO> obtenerPorId(Integer id);
    CompraGarageResponseDTO crearCompraGarage(CompraGarageDTO dto);
    CompraGarageResponseDTO actualizarCompraGarage(Integer id, CompraGarageDTO dto);
    void eliminarCompraGarage(Integer id);
}
