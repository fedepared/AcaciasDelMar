package com.acacias_del_mar.services.CompraGarage;

import com.acacias_del_mar.DTOs.CompraGarageDTO;
import com.acacias_del_mar.entities.CompraGarage;
import java.util.List;
import java.util.Optional;

public interface CompraGarageService {
    List<CompraGarage> obtenerTodas();
    Optional<CompraGarage> obtenerPorId(Integer id);
    CompraGarage crearCompraGarage(CompraGarageDTO dto);
    CompraGarage actualizarCompraGarage(Integer id, CompraGarageDTO dto);
    void eliminarCompraGarage(Integer id);
}
