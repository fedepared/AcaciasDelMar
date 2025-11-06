package com.acacias_del_mar.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "tipos_vehiculo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoVehiculo {
    @Id
    @Column(name = "id_tipo_vehiculo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoVehiculo;
    
    @Column(name = "denominacion",nullable = false)
    @NotNull(message = "La denominacion no puede ser nula")
    @Max(value=45, message = "Nombre demasiado extenso")
    private String denominacion; 
    
}
