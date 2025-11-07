package com.acacias_del_mar.services.CompraGarage;

import com.acacias_del_mar.DTOs.CompraGarageDTO;
import com.acacias_del_mar.DTOs.EntityMapper;
import com.acacias_del_mar.entities.CompraGarage;
import com.acacias_del_mar.entities.Garage;
import com.acacias_del_mar.entities.Socio;
import com.acacias_del_mar.repositories.CompraGarageRepository;
import com.acacias_del_mar.repositories.GarageRepository;
import com.acacias_del_mar.repositories.SocioRepository;
import com.acacias_del_mar.services.CompraGarage.CompraGarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompraGarageServiceImpl implements CompraGarageService {

    @Autowired
    private CompraGarageRepository repository;
    @Autowired
    private SocioRepository socioRepository; 
    @Autowired
    private GarageRepository garageRepository; 
    @Autowired
    private EntityMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<CompraGarageDTO> obtenerTodas() {
        return repository.findAll().stream()
                .map(mapper::toResponseDTO) // ¡Magia!
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CompraGarageDTO> obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(mapper::toResponseDTO); // ¡Magia!
    }

    @Override
    @Transactional
    public CompraGarageDTO crearCompraGarage(CompraGarageDTO dto) {
        // 1. Lógica de negocio
        Socio socio = socioRepository.findById(dto.getIdSocio())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado..."));
        Garage garage = garageRepository.findById(dto.getIdGarage())
                .orElseThrow(() -> new RuntimeException("Garage no encontrado..."));
        
        // 2. Mapeo
        CompraGarage nuevaCompra = mapper.toEntity(dto, socio, garage); // ¡Magia!
        
        CompraGarage guardada = repository.save(nuevaCompra);
        return mapper.toResponseDTO(guardada);
    }

    @Override
    @Transactional
    public CompraGarageDTO actualizarCompraGarage(Integer id, CompraGarageDTO dto) {
        // 1. Lógica de negocio
        CompraGarage compraExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada..."));
        Socio socio = socioRepository.findById(dto.getIdSocio())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado..."));
        Garage garage = garageRepository.findById(dto.getIdGarage())
                .orElseThrow(() -> new RuntimeException("Garage no encontrado..."));
        
        // 2. Mapeo
        mapper.updateEntityFromDto(dto, socio, garage, compraExistente); // ¡Magia!
        
        CompraGarage actualizada = repository.save(compraExistente);
        return mapper.toResponseDTO(actualizada);
    }

    @Override
    @Transactional
    public void eliminarCompraGarage(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Compra no encontrada: " + id);
        }
        repository.deleteById(id);
    }
}