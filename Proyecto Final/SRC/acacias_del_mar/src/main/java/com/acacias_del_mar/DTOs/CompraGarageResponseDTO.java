package com.acacias_del_mar.DTOs;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CompraGarageResponseDTO {
    private Integer idComprasGarages;
    private LocalDate fechaCompra;
    
    // Objetos anidados (DTO)
    private SocioResponseDTO socio; 
    private GarageResponseDTO garage; 
}