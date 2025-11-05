package com.acacias_del_mar.DTOs;
import com.acacias_del_mar.entities.TipoUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistroDTO {
    @NotBlank(message = "El nombre de usuario es obligatorio")
    private String nombre; 
    
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;
    
    @NotBlank(message = "El tipo de usuario es obligatorio")
    private TipoUsuario tipoUsuario;
}
