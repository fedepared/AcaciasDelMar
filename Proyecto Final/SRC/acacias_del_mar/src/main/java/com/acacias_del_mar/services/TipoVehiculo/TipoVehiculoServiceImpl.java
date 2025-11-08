package com.acacias_del_mar.services.TipoVehiculo;

import com.acacias_del_mar.DTOs.EntityMapper;
import com.acacias_del_mar.DTOs.TipoVehiculoDTO;
import com.acacias_del_mar.services.TipoVehiculo.TipoVehiculoService;
import com.acacias_del_mar.entities.TipoVehiculo;
import com.acacias_del_mar.exception.GeneralException;
import com.acacias_del_mar.repositories.TipoVehiculoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional

public class TipoVehiculoServiceImpl implements TipoVehiculoService{

    @Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;

    @Autowired
    private EntityMapper mapper;
    
   @Override
    @Transactional(readOnly = true)
    public List<TipoVehiculoDTO> obtenerTodos() {
        return tipoVehiculoRepository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }
    
}
