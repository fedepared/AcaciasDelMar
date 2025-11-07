package com.acacias_del_mar.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AsignacionEmpleadoZonaDTO {

    private Integer idAsignacionEmpleadoZona;
    @NotNull(message = "El ID de empleado es obligatorio")
    private Integer idEmpleado;

    @NotNull(message = "El ID de zona es obligatorio")
    private Integer idZona;
}
