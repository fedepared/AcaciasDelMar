/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acacias_del_mar.services.AsignacionZonaEmpleado;

import com.acacias_del_mar.DTOs.AsignacionEmpleadoZonaDTO;
import com.acacias_del_mar.entities.AsignacionEmpleadoZona;
import com.acacias_del_mar.repositories.AsignacionEmpleadoZonaRepository;
import com.acacias_del_mar.repositories.EmpleadoRepository;
import com.acacias_del_mar.repositories.ZonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FPARED
 */
public class AsignacionEmpleadoZonaServiceImpl implements AsignacionEmpleadoZonaService {

    @Autowired
    private AsignacionEmpleadoZonaRepository repository;
    @Autowired
    private EmpleadoRepository empleadoRepository; // Necesario
    @Autowired
    private ZonaRepository zonaRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<AsignacionEmpleadoZona> obtenerTodas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AsignacionEmpleadoZona> obtenerPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    @Transactional
    public AsignacionEmpleadoZona crearAsignacion(AsignacionEmpleadoZonaDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    @Transactional
    public AsignacionEmpleadoZona actualizarAsignacion(Integer id, AsignacionEmpleadoZonaDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    @Transactional
    public void eliminarAsignacion(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
