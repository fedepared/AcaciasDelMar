/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acacias_del_mar.services.Socio;

import com.acacias_del_mar.DTOs.SocioDTO;
import com.acacias_del_mar.entities.Socio;
import com.acacias_del_mar.repositories.SocioRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class SocioServiceImpl implements SocioService {

    @Autowired
    private SocioRepository socioRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Socio> obtenerTodosLosSocios() {
        return socioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Socio> obtenerSocioPorId(Integer id) {
        return socioRepository.findById(id);
    }

    @Override
    @Transactional
    public Socio crearSocio(SocioDTO socioDTO) {
        if(socioRepository.existsByNombreAndApellido(socioDTO.getNombre(), socioDTO.getApellido()))
        {
            throw new RuntimeException("Error: ese socio ya existe");
        }
        
        Socio nuevoSocio = new Socio();
        nuevoSocio.setNombre(socioDTO.getNombre());
        nuevoSocio.setApellido(socioDTO.getNombre());
        nuevoSocio.setDireccion(socioDTO.getDireccion());
        nuevoSocio.setTelefono(socioDTO.getTelefono());
        nuevoSocio.setFechaDeIngreso(socioDTO.getFechaDeIngreso());
        
        return socioRepository.save(nuevoSocio);
        
    }

    @Override
    public Socio actualizarSocio(Integer id, SocioDTO socioDTO) {
        Socio socioDb = socioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Error: Socio no encontrado"));
        
        socioDb.setNombre(socioDTO.getNombre());
        socioDb.setApellido(socioDTO.getNombre());
        socioDb.setDireccion(socioDTO.getDireccion());
        socioDb.setTelefono(socioDTO.getTelefono());
        socioDb.setFechaDeIngreso(socioDTO.getFechaDeIngreso());
        
        return socioRepository.save(socioDb);
        
        
    }

    @Override
    @Transactional
    public void eliminarSocio(Integer id) {
        if(!socioRepository.existsById(id))
            throw new RuntimeException("Error: Socio con ese id no encontrado"+ id);
        
        socioRepository.deleteById(id); 
    }
    
    
}
