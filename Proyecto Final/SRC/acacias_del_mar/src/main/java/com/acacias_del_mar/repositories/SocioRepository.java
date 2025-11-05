package com.acacias_del_mar.repositories;

import com.acacias_del_mar.entities.Socio;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SocioRepository extends JpaRepository<Socio,Integer> {
    
    List<Socio> findByApellido(String apellido);
    
    Optional<Socio> findByTelefono(String telefono);
    
    boolean existsByTelefono(String telefono);
    
    boolean existsByNombreAndApellido(String nombre,String apellido);
    
}
