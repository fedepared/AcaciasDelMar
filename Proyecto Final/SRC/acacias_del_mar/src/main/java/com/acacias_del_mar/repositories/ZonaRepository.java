
package com.acacias_del_mar.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.acacias_del_mar.entities.Zona;
import java.util.List;
import java.util.Optional;

public interface ZonaRepository extends JpaRepository<Zona,Integer> {

    boolean existsByLetra(char letra);
}
