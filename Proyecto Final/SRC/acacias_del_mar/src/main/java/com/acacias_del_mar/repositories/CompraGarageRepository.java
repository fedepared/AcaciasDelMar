package com.acacias_del_mar.repositories;

import com.acacias_del_mar.entities.CompraGarage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CompraGarageRepository extends JpaRepository<CompraGarage,Integer> {
    List<CompraGarage> findBySocio(Integer socioId);
    List<CompraGarage> findByIdGarage(Integer garageId);
}
