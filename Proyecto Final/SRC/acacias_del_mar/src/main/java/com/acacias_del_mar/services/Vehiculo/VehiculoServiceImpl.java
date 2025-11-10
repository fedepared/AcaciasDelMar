package com.acacias_del_mar.services.Vehiculo;


import com.acacias_del_mar.DTOs.EntityMapper;
import com.acacias_del_mar.DTOs.VehiculoDTO;
import com.acacias_del_mar.DTOs.VehiculoResponseDTO;
import com.acacias_del_mar.entities.Socio;
import com.acacias_del_mar.entities.TipoVehiculo;
import com.acacias_del_mar.entities.Vehiculo;
import com.acacias_del_mar.repositories.SocioRepository;
import com.acacias_del_mar.repositories.TipoVehiculoRepository;
import com.acacias_del_mar.repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;
    @Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;
    @Autowired
    private SocioRepository socioRepository;
    
    @Autowired
    private EntityMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<VehiculoResponseDTO> obtenerTodos() {
        return vehiculoRepository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<VehiculoResponseDTO> obtenerPorId(Integer id) {
        return vehiculoRepository.findById(id)
                .map(mapper::toResponseDTO); 
    }

    @Override
    @Transactional
    public VehiculoResponseDTO crearVehiculo(VehiculoDTO vehiculoDTO) {
        if (vehiculoRepository.existsByMatricula(vehiculoDTO.getMatricula())) {
            throw new RuntimeException("Error: La matrícula ya está registrada.");
        }

        
        TipoVehiculo tipo = tipoVehiculoRepository.findById(vehiculoDTO.getIdTipoVehiculo())
                .orElseThrow(() -> new RuntimeException("Tipo de vehículo no encontrado"));
        
        Socio socio = socioRepository.findById(vehiculoDTO.getIdSocioDueño())
                .orElseThrow(() -> new RuntimeException("Socio dueño no encontrado"));

        
        Vehiculo nuevoVehiculo = mapper.toEntity(vehiculoDTO, tipo, socio);

        
        Vehiculo guardado = vehiculoRepository.save(nuevoVehiculo);
        return mapper.toResponseDTO(guardado);
    }

    @Override
    @Transactional
    public VehiculoResponseDTO actualizarVehiculo(Integer id, VehiculoDTO vehiculoDTO) {
        
        Vehiculo vehiculoExistente = vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
        
        TipoVehiculo tipo = tipoVehiculoRepository.findById(vehiculoDTO.getIdTipoVehiculo())
                .orElseThrow(() -> new RuntimeException("Tipo de vehículo no encontrado"));

        Socio socio = socioRepository.findById(vehiculoDTO.getIdSocioDueño())
                .orElseThrow(() -> new RuntimeException("Socio dueño no encontrado"));

        
        mapper.updateEntityFromDto(vehiculoDTO, tipo, socio, vehiculoExistente); // ¡Magia!

        
        Vehiculo actualizado = vehiculoRepository.save(vehiculoExistente);
        return mapper.toResponseDTO(actualizado);
    }

    @Override
    @Transactional
    public void eliminarVehiculo(Integer id) {
        if (!vehiculoRepository.existsById(id)) {
            throw new RuntimeException("Vehículo no encontrado");
        }
        vehiculoRepository.deleteById(id);
    }
    
}
