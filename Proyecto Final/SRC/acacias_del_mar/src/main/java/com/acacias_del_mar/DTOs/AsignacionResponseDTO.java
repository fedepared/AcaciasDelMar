package com.acacias_del_mar.DTOs;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AsignacionResponseDTO {
    private Integer idAsignacion;
    private LocalDate fechaAsignacion;
    
    private VehiculoResponseDTO vehiculo; 
    private GarageResponseDTO garage; 
}
