package com.acacias_del_mar.DTOs;

import lombok.Data;

@Data
public class VehiculoResponseDTO {
    private Integer idVehiculo;
    private String matricula;
    private String marca;
    private Integer profundidad;
    private Integer alto;
    private Integer ancho;

    // Objetos anidados (DTO)
    private TipoVehiculoResponseDTO tipoVehiculo; 
    private SocioResponseDTO socioDueño; 
}
