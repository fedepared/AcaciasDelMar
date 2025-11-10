package com.acacias_del_mar.DTOs;

import lombok.Data;

@Data
public class ZonaResponseDTO {
    private Integer idZona;
    private String letra;
    private Integer profundidad;
    private Integer ancho;
    
    // Objeto anidado (DTO)
    private TipoVehiculoResponseDTO tipoVehiculo; 
}
