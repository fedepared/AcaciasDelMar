package com.acacias_del_mar.repositories;

import com.acacias_del_mar.entities.AsignacionEmpleadoZona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsignacionEmpleadoZonaRepository extends JpaRepository<AsignacionEmpleadoZona,Integer> {
    List<AsignacionEmpleadoZona> findByEmpleadoIdEmpleado(Integer empleadoId);
    List<AsignacionEmpleadoZona> findByZonaIdZona(Integer zonaId);
}
