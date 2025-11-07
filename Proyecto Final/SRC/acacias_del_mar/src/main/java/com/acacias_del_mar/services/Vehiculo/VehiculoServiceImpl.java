package com.acacias_del_mar.services.Vehiculo;


import com.acacias_del_mar.DTOs.EntityMapper;
import com.acacias_del_mar.DTOs.VehiculoDTO;
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

public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;
    @Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;
    @Autowired
    private SocioRepository socioRepository;
    
    @Autowired
    private EntityMapper mapper; // ¡Inyectamos el Mapper!

    @Override
    @Transactional(readOnly = true)
    public List<VehiculoDTO> obtenerTodos() {
        return vehiculoRepository.findAll().stream()
                .map(mapper::toResponseDTO) // Usamos el mapper
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<VehiculoDTO> obtenerPorId(Integer id) {
        return vehiculoRepository.findById(id)
                .map(mapper::toResponseDTO); 
    }

    @Override
    @Transactional
    public VehiculoDTO crearVehiculo(VehiculoDTO vehiculoDTO) {
        if (vehiculoRepository.existsByMatricula(vehiculoDTO.getMatricula())) {
            throw new RuntimeException("Error: La matrícula ya está registrada.");
        }

        
        TipoVehiculo tipo = tipoVehiculoRepository.findById(vehiculoDTO.getIdTipoVehiculo())
                .orElseThrow(() -> new RuntimeException("Tipo de vehículo no encontrado"));
        
        Socio socio = socioRepository.findById(vehiculoDTO.getIdSocioDueño())
                .orElseThrow(() -> new RuntimeException("Socio dueño no encontrado"));

        
        Vehiculo nuevoVehiculo = mapper.toEntity(vehiculoDTO, tipo, socio);

        // 4. Guardar y devolver DTO
        Vehiculo guardado = vehiculoRepository.save(nuevoVehiculo);
        return mapper.toResponseDTO(guardado);
    }

    @Override
    @Transactional
    public VehiculoDTO actualizarVehiculo(Integer id, VehiculoDTO vehiculoDTO) {
        // 1. Lógica de negocio (Buscar entidades)
        Vehiculo vehiculoExistente = vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
        
        TipoVehiculo tipo = tipoVehiculoRepository.findById(vehiculoDTO.getIdTipoVehiculo())
                .orElseThrow(() -> new RuntimeException("Tipo de vehículo no encontrado"));

        Socio socio = socioRepository.findById(vehiculoDTO.getIdSocioDueño())
                .orElseThrow(() -> new RuntimeException("Socio dueño no encontrado"));

        // 2. Mapeo (Actualizar entidad existente)
        mapper.updateEntityFromDto(vehiculoDTO, tipo, socio, vehiculoExistente); // ¡Magia!

        // 3. Guardar y devolver DTO
        Vehiculo actualizado = vehiculoRepository.save(vehiculoExistente);
        return mapper.toResponseDTO(actualizado);
    }

    @Override
    @Transactional
    public void eliminarVehiculo(Integer id) {
        if (!vehiculoRepository.existsById(id)) {
            throw new RuntimeException("Vehículo no encontrado");
        }
        // CUIDADO: Esto fallará si el vehículo tiene 'Asignaciones'
        // Deberías manejar la lógica de borrado en cascada o de validación
        vehiculoRepository.deleteById(id);
    }
    
}
