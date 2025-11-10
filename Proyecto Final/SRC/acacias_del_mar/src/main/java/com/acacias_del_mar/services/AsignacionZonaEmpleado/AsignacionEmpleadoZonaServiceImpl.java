package com.acacias_del_mar.services.AsignacionZonaEmpleado;

import com.acacias_del_mar.DTOs.AsignacionEmpleadoZonaDTO;
import com.acacias_del_mar.DTOs.AsignacionEmpleadoZonaResponseDTO;
import com.acacias_del_mar.DTOs.EntityMapper;
import com.acacias_del_mar.entities.AsignacionEmpleadoZona;
import com.acacias_del_mar.entities.Empleado;
import com.acacias_del_mar.entities.Zona;
import com.acacias_del_mar.repositories.AsignacionEmpleadoZonaRepository;
import com.acacias_del_mar.repositories.EmpleadoRepository;
import com.acacias_del_mar.repositories.ZonaRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AsignacionEmpleadoZonaServiceImpl implements AsignacionEmpleadoZonaService {

    @Autowired
    private AsignacionEmpleadoZonaRepository repository;
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private ZonaRepository zonaRepository;
    @Autowired
    private EntityMapper mapper;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<AsignacionEmpleadoZonaResponseDTO> obtenerTodas() {
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AsignacionEmpleadoZonaResponseDTO> obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(mapper::toResponseDTO);
    }

    @Override
    @Transactional
    public AsignacionEmpleadoZonaResponseDTO crearAsignacion(AsignacionEmpleadoZonaDTO dto) {
        Empleado empleado = empleadoRepository.findById(dto.getIdEmpleado())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado..."));
        Zona zona = zonaRepository.findById(dto.getIdZona())
                .orElseThrow(() -> new RuntimeException("Zona no encontrada..."));
        
        AsignacionEmpleadoZona nuevaAsignacion = mapper.toEntity(dto, empleado, zona);
        
        AsignacionEmpleadoZona guardada = repository.save(nuevaAsignacion);
        return mapper.toResponseDTO(guardada);
    }

    @Override
    @Transactional
    public AsignacionEmpleadoZonaResponseDTO actualizarAsignacion(Integer id, AsignacionEmpleadoZonaDTO dto) {
        
        AsignacionEmpleadoZona asignacionExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada..."));
        Empleado empleado = empleadoRepository.findById(dto.getIdEmpleado())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado..."));
        Zona zona = zonaRepository.findById(dto.getIdZona())
                .orElseThrow(() -> new RuntimeException("Zona no encontrada..."));

        
        mapper.updateEntityFromDto(dto, empleado, zona, asignacionExistente); // ¡Magia!
        
        AsignacionEmpleadoZona actualizada = repository.save(asignacionExistente);
        return mapper.toResponseDTO(actualizada);
    }

    @Override
    @Transactional
    public void eliminarAsignacion(Integer id) {
       if(!repository.existsById(id))
       {
           throw new RuntimeException("No existe esa asignacion");
       }
       repository.deleteById(id);
    }
}
