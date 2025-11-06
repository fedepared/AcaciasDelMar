package com.acacias_del_mar.repositories;

import com.acacias_del_mar.entities.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageRepository extends JpaRepository<Garage,Integer> {
    boolean exstisByNumero(Integer numero);
}
