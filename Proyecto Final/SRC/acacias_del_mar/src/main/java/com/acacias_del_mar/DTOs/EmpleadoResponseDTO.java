package com.acacias_del_mar.DTOs;

import lombok.Data;

@Data
public class EmpleadoResponseDTO {
    private Integer idEmpleado;
    private Integer codigo;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String especialidad;
}
