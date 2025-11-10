package com.acacias_del_mar.DTOs;

import java.time.LocalDate;
import lombok.Data;

@Data
public class SocioResponseDTO {
    private Integer idSocio;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private LocalDate fechaDeIngreso;
}
