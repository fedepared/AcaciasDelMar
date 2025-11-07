package com.acacias_del_mar.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class AsignacionDTO {
    private Integer idAsignacion;
    @NotNull(message = "El ID de vehículo es obligatorio")
    private Integer idVehiculo;

    @NotNull(message = "El ID de garage es obligatorio")
    private Integer idGarage;

    private LocalDate fechaAsignacion;
}
