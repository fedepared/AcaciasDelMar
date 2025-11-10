
package com.acacias_del_mar.DTOs;
import lombok.Data;

@Data
public class GarageResponseDTO {
    private Integer idGarage;
    private Integer numero;
    private Integer lecturaContadorLuz;
    private boolean tieneServiciosContratados;
    

    private ZonaResponseDTO zona; 
}
