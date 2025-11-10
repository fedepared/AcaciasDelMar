package com.acacias_del_mar.DTOs;

import lombok.Data;

@Data
public class AsignacionEmpleadoZonaResponseDTO {
    private Integer idAsignacionEmpleadoZona;
    
    // Objetos anidados (DTO)
    private EmpleadoResponseDTO empleado; 
    private ZonaResponseDTO zona; 
}
