package com.acacias_del_mar.DTOs;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class ZonaDTO {
    
    private Integer idZona; 
    @NotBlank(message = "la letra es obligatoria")
    private char letra;
    
    @NotNull(message = "el tipo de vehiculo es obligatorio")
    private int idTipoVehiculo;
    
    @NotNull(message = "la profundidad es obligatoria")
    private int profundidad;
    @NotNull(message = "el ancho es obligatorio")
    private int ancho;
    
    private TipoVehiculoDTO tipoVehiculo;
}
