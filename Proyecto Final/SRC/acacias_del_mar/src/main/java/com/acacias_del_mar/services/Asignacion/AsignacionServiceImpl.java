package com.acacias_del_mar.services.Asignacion;

import com.acacias_del_mar.repositories.VehiculoRepository;
import com.acacias_del_mar.DTOs.AsignacionDTO;
import com.acacias_del_mar.DTOs.AsignacionResponseDTO;
import com.acacias_del_mar.DTOs.EntityMapper;
import com.acacias_del_mar.entities.Asignacion;
import com.acacias_del_mar.entities.Garage;
import com.acacias_del_mar.entities.Vehiculo;
import com.acacias_del_mar.repositories.AsignacionRepository;
import com.acacias_del_mar.repositories.GarageRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AsignacionServiceImpl implements AsignacionService {

    @Autowired
    private AsignacionRepository asignacionRepository;
    @Autowired
    private VehiculoRepository vehiculoRepository;
    @Autowired
    private GarageRepository garageRepository;
    @Autowired
    private EntityMapper mapper;
    
    @Override
    @Transactional(readOnly = true)
    public List<AsignacionResponseDTO> obtenerTodas() {
        return asignacionRepository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AsignacionResponseDTO> obtenerPorId(Integer id) {
        return asignacionRepository.findById(id)
                .map(mapper::toResponseDTO);
        
    }

    @Override
    @Transactional
    public AsignacionResponseDTO crearAsignacion(AsignacionDTO asignacionDTO) {
        Vehiculo vehiculo = vehiculoRepository.findById(asignacionDTO.getIdVehiculo())
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado..."));
        Garage garage = garageRepository.findById(asignacionDTO.getIdGarage())
                .orElseThrow(() -> new RuntimeException("Garage no encontrado..."));

        Asignacion nuevaAsignacion = mapper.toEntity(asignacionDTO, vehiculo, garage); // ¡Magia!

        Asignacion guardada = asignacionRepository.save(nuevaAsignacion);
        return mapper.toResponseDTO(guardada);
    }

    @Override
    @Transactional
    public AsignacionResponseDTO actualizarAsignacion(Integer id, AsignacionDTO asignacionDTO) {
        Asignacion asignacionExistente = asignacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignacion no encontrada"));
        
        Vehiculo vehiculo = vehiculoRepository.findById(asignacionDTO.getIdVehiculo())
                .orElseThrow(() -> new RuntimeException("Vehiculo no encontrado "));
        
        Garage garage = garageRepository.findById(asignacionDTO.getIdGarage())
                .orElseThrow(()->new RuntimeException("Garage no encontrado"));
        
        mapper.updateEntityFromDto(asignacionDTO, vehiculo, garage, asignacionExistente);
        
        Asignacion actualizada = asignacionRepository.save(asignacionExistente);
        
        return mapper.toResponseDTO(actualizada);
        
    }

    @Override
    @Transactional
    public void eliminarAsignacion(Integer id) {
        if(!asignacionRepository.existsById(id))
        {
            throw new RuntimeException("No existe esa asignacion");
        }
        
        asignacionRepository.deleteById(id);
    }
    
}
