package com.acacias_del_mar.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Usuario {
    @Id
    @Column(name = "id_usuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    
    @Column(name = "nombre",nullable = true)
    @Size(max=15, message = "Nombre demasiado extenso (max 15 caracteres)")
    private String nombre; 
    
    @Column(name = "pass",nullable = false,length=128)
    private String pass; 
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario",nullable = false)
//    @Max(value=15, message = "tipo de usuario demasiado largo")
    private TipoUsuario tipoUsuario; 
}



