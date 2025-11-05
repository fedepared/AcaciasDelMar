package com.acacias_del_mar.services.Zona;

import com.acacias_del_mar.DTOs.ZonaDTO;
import com.acacias_del_mar.entities.TipoVehiculo;
import com.acacias_del_mar.entities.Zona;
import com.acacias_del_mar.repositories.TipoVehiculoRepository;
import com.acacias_del_mar.repositories.ZonaRepository;
import java.util.List;
import java.util.Optional;
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
    
    @Autowired
    private TipoVehiculoRepository tvRepository;

    
    

    @Override
    public Zona crearZona(ZonaDTO zonaDTO) {
        if(zonaRepository.existsByLetra(zonaDTO.getLetra()))
        {
            throw new RuntimeException("Error: la letra ya existe");
        }
        
        TipoVehiculo tipoVehiculoEncontrado = tvRepository.findById(zonaDTO.getIdTipoVehiculo())
            .orElseThrow(() -> new RuntimeException("Error: el tipo de vehiculo no existe"));    
        
        Zona nuevaZona = new Zona();
        nuevaZona.setLetra(zonaDTO.getLetra());
        nuevaZona.setAncho(zonaDTO.getAncho());
        nuevaZona.setProfundidad(zonaDTO.getProfundidad());
        nuevaZona.setTipoVehiculo(tipoVehiculoEncontrado);
        
        return zonaRepository.save(nuevaZona);
    
    }
    
    @Override
    public List<Zona> obtenerZonas() {
        return zonaRepository.findAll();
    }
    @Override
    public Optional<Zona> obtenerPorId(Integer id) {
        return zonaRepository.findById(id);
    }
    @Override
    public Zona actualizarZona(Integer id, ZonaDTO zonaDTO) {
        
        return null;
        
    }
    @Override
    public void eliminarZona(Integer id) {
        
    }
    
    
    
    
}
