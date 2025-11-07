/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acacias_del_mar.services.Socio;

import com.acacias_del_mar.DTOs.EntityMapper;
import com.acacias_del_mar.DTOs.SocioDTO;
import com.acacias_del_mar.entities.Socio;
import com.acacias_del_mar.repositories.SocioRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class SocioServiceImpl implements SocioService {

    @Autowired
    private SocioRepository socioRepository;
    @Autowired
    private EntityMapper mapper;
    
    @Override
    @Transactional(readOnly = true)
    public List<SocioDTO> obtenerTodosLosSocios() {
        return socioRepository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SocioDTO> obtenerSocioPorId(Integer id) {
        return socioRepository.findById(id)
                .map(mapper::toResponseDTO);
    }

    @Override
    @Transactional
    public SocioDTO crearSocio(SocioDTO socioDTO) {
        if(socioRepository.existsByNombreAndApellido(socioDTO.getNombre(), socioDTO.getApellido()))
        {
            throw new RuntimeException("Error: ese socio ya existe");
        }
        
        Socio nuevoSocio = mapper.toEntity(socioDTO);
        Socio guardado = socioRepository.save(nuevoSocio);
        return mapper.toResponseDTO(guardado);
        
    }

    @Override
    @Transactional
    public SocioDTO actualizarSocio(Integer id, SocioDTO socioDTO) {
        Socio socioDb = socioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Error: Socio no encontrado"));
        
        mapper.updateEntityFromDto(socioDTO, socioDb);
        
        Socio actualizado = socioRepository.save(socioDb);
        
        return mapper.toResponseDTO(actualizado);
        
        
    }

    @Override
    @Transactional
    public void eliminarSocio(Integer id) {
        if(!socioRepository.existsById(id))
            throw new RuntimeException("Error: Socio con ese id no encontrado"+ id);
        
        socioRepository.deleteById(id); 
    }
    
    
}
