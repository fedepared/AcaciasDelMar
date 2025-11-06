package com.acacias_del_mar.services.Asignacion;

import com.acacias_del_mar.repositories.VehiculoRepository;
import com.acacias_del_mar.DTOs.AsignacionDTO;
import com.acacias_del_mar.entities.Asignacion;
import com.acacias_del_mar.repositories.AsignacionRepository;
import com.acacias_del_mar.repositories.GarageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class AsignacionServiceImpl implements AsignacionService {

    @Autowired
    private AsignacionRepository asignacionRepository;
    @Autowired
    private VehiculoRepository vehiculoRepository;
    @Autowired
    private GarageRepository garageRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Asignacion> obtenerTodas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Asignacion> obtenerPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    @Transactional
    public Asignacion crearAsignacion(AsignacionDTO asignacionDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    @Transactional
    public Asignacion actualizarAsignacion(Integer id, AsignacionDTO asignacionDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    @Transactional
    public void eliminarAsignacion(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
