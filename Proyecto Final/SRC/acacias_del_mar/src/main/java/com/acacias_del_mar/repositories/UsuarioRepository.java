package com.acacias_del_mar.repositories;

import com.acacias_del_mar.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    
    //Metodo de consulta derivados ("derived query methods")
    boolean existsByNombre(String nombre);
    
    
    
}
