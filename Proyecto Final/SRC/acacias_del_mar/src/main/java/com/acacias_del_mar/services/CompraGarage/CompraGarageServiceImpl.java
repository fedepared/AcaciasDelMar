package com.acacias_del_mar.services.CompraGarage;

import com.acacias_del_mar.DTOs.CompraGarageDTO;
import com.acacias_del_mar.entities.CompraGarage;
import com.acacias_del_mar.entities.Garage;
import com.acacias_del_mar.entities.Socio;
import com.acacias_del_mar.repositories.CompraGarageRepository;
import com.acacias_del_mar.repositories.GarageRepository;
import com.acacias_del_mar.repositories.SocioRepository;
import com.acacias_del_mar.services.CompraGarage.CompraGarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CompraGarageServiceImpl implements CompraGarageService {

    @Autowired
    private CompraGarageRepository repository;
    @Autowired
    private SocioRepository socioRepository; // Necesario
    @Autowired
    private GarageRepository garageRepository; // Necesario

    @Override
    @Transactional(readOnly = true)
    public List<CompraGarage> obtenerTodas() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CompraGarage> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public CompraGarage crearCompraGarage(CompraGarageDTO dto) {
        Socio socio = socioRepository.findById(dto.getIdSocio())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado: " + dto.getIdSocio()));

        Garage garage = garageRepository.findById(dto.getIdGarage())
                .orElseThrow(() -> new RuntimeException("Garage no encontrado: " + dto.getIdGarage()));

        // TODO: Validación de negocio (ej. el garage no esté ya comprado)

        CompraGarage nuevaCompra = new CompraGarage();
        nuevaCompra.setSocio(socio);
        nuevaCompra.setGarage(garage);
        nuevaCompra.setFechaCompra(dto.getFechaCompra());

        return repository.save(nuevaCompra);
    }

    @Override
    @Transactional
    public CompraGarage actualizarCompraGarage(Integer id, CompraGarageDTO dto) {
        CompraGarage compraExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada: " + id));

        Socio socio = socioRepository.findById(dto.getIdSocio())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado: " + dto.getIdSocio()));

        Garage garage = garageRepository.findById(dto.getIdGarage())
                .orElseThrow(() -> new RuntimeException("Garage no encontrado: " + dto.getIdGarage()));

        compraExistente.setSocio(socio);
        compraExistente.setGarage(garage);
        compraExistente.setFechaCompra(dto.getFechaCompra());

        return repository.save(compraExistente);
    }

    @Override
    @Transactional
    public void eliminarCompraGarage(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Compra no encontrada: " + id);
        }
        repository.deleteById(id);
    }
}