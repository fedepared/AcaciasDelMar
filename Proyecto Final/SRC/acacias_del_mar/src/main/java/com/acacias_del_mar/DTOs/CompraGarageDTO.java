package com.acacias_del_mar.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import java.time.LocalDate;

@Data
public class CompraGarageDTO {

    @NotNull(message = "El ID de socio es obligatorio")
    private Integer idSocio;

    @NotNull(message = "El ID de garage es obligatorio")
    private Integer idGarage;

    @NotNull(message = "La fecha de compra es obligatoria")
    @PastOrPresent(message = "La fecha de compra no puede ser futura")
    private LocalDate fechaCompra;
}