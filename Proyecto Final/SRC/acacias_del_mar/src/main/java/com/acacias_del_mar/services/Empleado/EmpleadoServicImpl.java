package com.acacias_del_mar.services.Empleado;

import com.acacias_del_mar.DTOs.EmpleadoDTO;
import com.acacias_del_mar.DTOs.EntityMapper;
import com.acacias_del_mar.entities.Empleado;
import com.acacias_del_mar.repositories.EmpleadoRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoServicImpl implements EmpleadoService {

    @Autowired private EmpleadoRepository empleadoRepository;
    @Autowired private EntityMapper mapper;
            
    @Override
    @Transactional(readOnly = true)
    public List<EmpleadoDTO> obtenerTodos() {
        return empleadoRepository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EmpleadoDTO> obtenerPorId(Integer id) {
        return empleadoRepository.findById(id)
                .map(mapper::toResponseDTO);
    }

    @Override
    @Transactional
    public EmpleadoDTO crearEmpleado(EmpleadoDTO empleadoDTO) {
        
        Empleado nuevoEmpleado = mapper.toEntity(empleadoDTO);
        Empleado guardado = empleadoRepository.save(nuevoEmpleado);
        return mapper.toResponseDTO(guardado);
    }

    @Override
    public EmpleadoDTO actualizarEmpleado(Integer id, EmpleadoDTO empleadoDTO) {
        Empleado empleadoExistente = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ya existe ese empleado"));
        
        mapper.updateEntityFromDto(empleadoDTO, empleadoExistente);
        Empleado actualizado = empleadoRepository.save(empleadoExistente);
        
        return mapper.toResponseDTO(actualizado);
    }

    @Override
    public void eliminarEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }
    
}
