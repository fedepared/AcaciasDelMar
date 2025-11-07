package com.acacias_del_mar.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class VehiculoDTO {
    private Integer idVehiculo;
    @NotBlank(message = "La matrícula es obligatoria")
    @Size(max = 10, message = "Matrícula demasiado larga")
    private String matricula;

    @Size(max = 45, message = "Marca demasiado larga")
    private String marca;

    private Integer profundidad;
    private Integer alto;
    private Integer ancho;

    @NotNull(message = "El ID del tipo de vehículo es obligatorio")
    private Integer idTipoVehiculo;

    @NotNull(message = "El ID del socio dueño es obligatorio")
    private Integer idSocioDueño;
}
