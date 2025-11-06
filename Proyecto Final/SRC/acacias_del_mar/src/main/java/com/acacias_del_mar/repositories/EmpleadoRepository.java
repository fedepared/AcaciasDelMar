package com.acacias_del_mar.repositories;

import com.acacias_del_mar.entities.Empleado;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {
    Optional<Empleado> findByCodigo(Integer codigo);
    boolean existsByTelefono(String telefono);
}
