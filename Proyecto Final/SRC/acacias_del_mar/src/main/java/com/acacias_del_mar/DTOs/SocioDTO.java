package com.acacias_del_mar.DTOs;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDate;

@Data
public class SocioDTO {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 25, message = "El nombre no puede exceder los 25 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 25, message = "El apellido no puede exceder los 25 caracteres")
    private String apellido;

    @Size(max = 255, message = "La dirección no puede exceder los 255 caracteres")
    private String direccion;

    @Size(max = 16, message = "El teléfono no puede exceder los 16 caracteres")
    private String telefono;

    @NotNull(message = "La fecha de ingreso es obligatoria")
    @PastOrPresent(message = "La fecha de ingreso no puede ser futura")
    private LocalDate fechaDeIngreso;
}
