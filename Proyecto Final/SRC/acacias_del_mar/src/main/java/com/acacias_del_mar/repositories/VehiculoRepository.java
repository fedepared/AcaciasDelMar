
package com.acacias_del_mar.repositories;

import com.acacias_del_mar.DTOs.VehiculoDTO;
import com.acacias_del_mar.entities.Vehiculo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehiculoRepository extends JpaRepository<Vehiculo,Integer> {

    boolean existsByMatricula(String matricula);

    Optional<Vehiculo> findByMatricula(String matricula);
}
