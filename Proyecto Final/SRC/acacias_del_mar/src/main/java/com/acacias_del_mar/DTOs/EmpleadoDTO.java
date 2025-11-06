package com.acacias_del_mar.DTOs;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data 
public class EmpleadoDTO {
    
    
    private Integer codigo;

    @Size(max = 45, message = "Nombre demasiado largo")
    private String nombre;

    @Size(max = 45, message = "Apellido demasiado largo")
    private String apellido;

    @Size(max = 255, message = "Dirección demasiado larga")
    private String direccion;

    @Size(max = 15, message = "Teléfono demasiado largo")
    private String telefono;

    @Size(max = 45, message = "Especialidad demasiado larga")
    private String especialidad;
}
