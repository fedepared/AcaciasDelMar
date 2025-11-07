package com.acacias_del_mar.services.Garage;

import com.acacias_del_mar.DTOs.EntityMapper;
import com.acacias_del_mar.DTOs.GarageDTO;
import com.acacias_del_mar.entities.Garage;
import com.acacias_del_mar.entities.Zona;
import com.acacias_del_mar.repositories.GarageRepository;
import com.acacias_del_mar.repositories.ZonaRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GarageServiceImpl implements GarageService{
    @Autowired
    private GarageRepository garageRepository;
    @Autowired
    private ZonaRepository zonaRepository;
    @Autowired
    private EntityMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<GarageDTO> obtenerTodos() {
        return garageRepository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<GarageDTO> obtenerPorId(Integer id) {
        return garageRepository.findById(id)
                .map(mapper::toResponseDTO);
    }

    @Override
    @Transactional
    public GarageDTO crearGarage(GarageDTO garageDTO) {
        if (garageRepository.existsByNumero(garageDTO.getNumero())) {
            throw new RuntimeException("Error: El número de garage ya existe.");
        }
        Zona zonaAsociada = zonaRepository.findById(garageDTO.getIdZona())
                .orElseThrow(() -> new RuntimeException("Error: Zona no encontrada..."));

        
        Garage nuevoGarage = mapper.toEntity(garageDTO, zonaAsociada);
        
        Garage guardado = garageRepository.save(nuevoGarage);
        return mapper.toResponseDTO(guardado);
    }

    @Override
    @Transactional
    public GarageDTO actualizarGarage(Integer id, GarageDTO garageDTO) {
        Garage garageExistente = garageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Garage no encontrado..."));
        
        Zona zonaAsociada = zonaRepository.findById(garageDTO.getIdZona())
                .orElseThrow(() -> new RuntimeException("Zona no encontrada"));
        
        mapper.updateEntityFromDto(garageDTO, zonaAsociada, garageExistente);
        
        Garage actualizado = garageRepository.save(garageExistente);
        return mapper.toResponseDTO(actualizado);
                
    }

    @Override
    @Transactional
    public void eliminarGarage(Integer id) {
        if(!garageRepository.existsById(id))
        {
            throw new RuntimeException("Error: no existe ese garage");
        }
        garageRepository.deleteById(id);
    }
    
    
}
