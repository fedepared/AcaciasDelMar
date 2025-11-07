package com.acacias_del_mar.services.CompraGarage;

import com.acacias_del_mar.DTOs.CompraGarageDTO;
import com.acacias_del_mar.entities.CompraGarage;
import java.util.List;
import java.util.Optional;

public interface CompraGarageService {
    List<CompraGarageDTO> obtenerTodas();
    Optional<CompraGarageDTO> obtenerPorId(Integer id);
    CompraGarageDTO crearCompraGarage(CompraGarageDTO dto);
    CompraGarageDTO actualizarCompraGarage(Integer id, CompraGarageDTO dto);
    void eliminarCompraGarage(Integer id);
}
