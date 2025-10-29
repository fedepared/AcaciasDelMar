package com.acacias_del_mar.repositories;

import com.acacias_del_mar.entities.TipoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface TipoVehiculoRepository extends JpaRepository<TipoVehiculo,Integer>{
    
}
