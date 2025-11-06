package com.acacias_del_mar.repositories;

import com.acacias_del_mar.entities.Asignacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignacionRepository extends JpaRepository<Asignacion,Integer> {
    List<Asignacion> findByVehiculoIdVehiculo(Integer vehiculoId);
    List<Asignacion> findByGarageIdGarage(Integer garageId);
}
