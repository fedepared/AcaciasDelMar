package com.acacias_del_mar.DTOs;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class ZonaDTO {
    
    
    @NotBlank(message = "La letra es obligatoria")
    @Size(max = 1, message = "La letra no puede exceder 1 caracter")
    private String letra;
    
    @NotNull(message = "el tipo de vehiculo es obligatorio")
    private int idTipoVehiculo;
    
    @NotNull(message = "la profundidad es obligatoria")
    private int profundidad;
    @NotNull(message = "el ancho es obligatorio")
    private int ancho;
}
