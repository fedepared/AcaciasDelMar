package com.acacias_del_mar.services.Zona;

import com.acacias_del_mar.DTOs.EntityMapper;
import com.acacias_del_mar.DTOs.ZonaDTO;
import com.acacias_del_mar.DTOs.ZonaResponseDTO;
import com.acacias_del_mar.entities.TipoVehiculo;
import com.acacias_del_mar.entities.Zona;
import com.acacias_del_mar.repositories.TipoVehiculoRepository;
import com.acacias_del_mar.repositories.ZonaRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class ZonaServiceImpl implements ZonaService {
    
     @Autowired
    private ZonaRepository zonaRepository;
    
    // Inyectamos el repo de TipoVehiculo para buscar la dependencia
    @Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;

    @Autowired
    private EntityMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<ZonaResponseDTO> obtenerTodas() {
        return zonaRepository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // --- MÉTODOS NUEVOS ---

    @Override
    @Transactional(readOnly = true)
    public Optional<ZonaResponseDTO> obtenerPorId(Integer id) {
        return zonaRepository.findById(id).map(mapper::toResponseDTO);
    }

    @Override
    @Transactional
    public ZonaResponseDTO crearZona(ZonaDTO zonaDTO) {
        if (zonaRepository.existsByLetra(zonaDTO.getLetra().charAt(0))) {
            throw new RuntimeException("Error: La letra de zona ya existe.");
        }
        
        TipoVehiculo tipoVehiculo = tipoVehiculoRepository.findById(zonaDTO.getIdTipoVehiculo())
                .orElseThrow(() -> new RuntimeException("Error: Tipo de Vehículo no encontrado con ID: " + zonaDTO.getIdTipoVehiculo()));

        Zona nuevaZona = mapper.toEntity(zonaDTO, tipoVehiculo);
        
        Zona guardada = zonaRepository.save(nuevaZona);
        

        return mapper.toResponseDTO(guardada);
    }

    @Override
    @Transactional
    public ZonaResponseDTO actualizarZona(Integer id, ZonaDTO zonaDTO) {
        // 1. Lógica de Negocio
        Zona zonaExistente = zonaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Zona no encontrada con ID: " + id));

        TipoVehiculo tipoVehiculo = tipoVehiculoRepository.findById(zonaDTO.getIdTipoVehiculo())
                .orElseThrow(() -> new RuntimeException("Error: Tipo de Vehículo no encontrado con ID: " + zonaDTO.getIdTipoVehiculo()));

        // 2. Mapeo (Actualizar entidad existente desde DTO)
        mapper.updateEntityFromDto(zonaDTO, tipoVehiculo, zonaExistente);
        
        Zona actualizada = zonaRepository.save(zonaExistente);
        
        // 3. Mapeo (Entidad -> DTO de respuesta)
        return mapper.toResponseDTO(actualizada);
    }

    @Override
    @Transactional
    public void eliminarZona(Integer id) {
        if (!zonaRepository.existsById(id)) {
            throw new RuntimeException("Zona no encontrada con ID: " + id);
        }
        // NOTA: Esto fallará si la Zona tiene Garages asignados.
        // En un proyecto real, se necesitaría lógica de borrado en cascada o validación.
        zonaRepository.deleteById(id);
    }
}
