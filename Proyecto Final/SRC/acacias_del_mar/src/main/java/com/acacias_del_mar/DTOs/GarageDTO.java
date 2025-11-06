package com.acacias_del_mar.DTOs;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class GarageDTO {
    @NotNull(message = "El número es obligatorio")
    private Integer numero;

    private Integer lecturaContadorLuz;

    @NotNull(message = "Debe indicar si tiene servicios")
    private Boolean tieneServiciosContratados;

    // El DTO recibe el ID de la Zona
    @NotNull(message = "El ID de la zona es obligatorio")
    private Integer idZona;
}
