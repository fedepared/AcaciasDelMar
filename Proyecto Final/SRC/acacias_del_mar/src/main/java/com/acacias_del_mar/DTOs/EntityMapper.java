package com.acacias_del_mar.DTOs;

import com.acacias_del_mar.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    EmpleadoDTO toResponseDTO(Empleado empleado);
    SocioDTO toResponseDTO(Socio socio);
    TipoVehiculoDTO toResponseDTO(TipoVehiculo tipoVehiculo);
    
    VehiculoDTO toResponseDTO(Vehiculo vehiculo);
    ZonaDTO toResponseDTO(Zona zona);
    GarageDTO toResponseDTO(Garage garage);
    
    

    // Entidades de Unión (Junction)
    AsignacionDTO toResponseDTO(Asignacion asignacion);
    AsignacionEmpleadoZonaDTO toResponseDTO(AsignacionEmpleadoZona asignacion);
    CompraGarageDTO toResponseDTO(CompraGarage compra);


    // --- 2. DTO DE ENTRADA -> ENTIDAD (Para CREAR) ---
    
    @Mapping(target = "idEmpleado", ignore = true)
    Empleado toEntity(EmpleadoDTO dto);

    @Mapping(target = "idSocio", ignore = true)
    Socio toEntity(SocioDTO dto);

    @Mapping(target = "idGarage", ignore = true)
    @Mapping(target = "zona", source = "zona") // 'zona' viene como parámetro
    Garage toEntity(GarageDTO dto, Zona zona);

    @Mapping(target = "idAsignacion", ignore = true)
    @Mapping(target = "vehiculo", source = "vehiculo")
    @Mapping(target = "garage", source = "garage")
    Asignacion toEntity(AsignacionDTO dto, Vehiculo vehiculo, Garage garage);

    @Mapping(target = "idAsignacionEmpleadoZona", ignore = true)
    @Mapping(target = "empleado", source = "empleado")
    @Mapping(target = "zona", source = "zona")
    AsignacionEmpleadoZona toEntity(AsignacionEmpleadoZonaDTO dto, Empleado empleado, Zona zona);

    @Mapping(target = "idComprasGarages", ignore = true)
    @Mapping(target = "socio", source = "socio")
    @Mapping(target = "garage", source = "garage")
    CompraGarage toEntity(CompraGarageDTO dto, Socio socio, Garage garage);


    
    
    @Mapping(target = "idEmpleado", ignore = true)
    void updateEntityFromDto(EmpleadoDTO dto, @MappingTarget Empleado empleado);

    @Mapping(target = "idSocio", ignore = true)
    void updateEntityFromDto(SocioDTO dto, @MappingTarget Socio socio);

    @Mapping(target = "idGarage", ignore = true)
    @Mapping(target = "zona", source = "zona")
    void updateEntityFromDto(GarageDTO dto, Zona zona, @MappingTarget Garage garage);

    @Mapping(target = "idAsignacion", ignore = true)
    @Mapping(target = "vehiculo", source = "vehiculo")
    @Mapping(target = "garage", source = "garage")
    void updateEntityFromDto(AsignacionDTO dto, Vehiculo vehiculo, Garage garage, @MappingTarget Asignacion asignacion);
    
    @Mapping(target = "idAsignacionEmpleadoZona", ignore = true)
    @Mapping(target = "empleado", source = "empleado")
    @Mapping(target = "zona", source = "zona")
    void updateEntityFromDto(AsignacionEmpleadoZonaDTO dto, Empleado empleado, Zona zona, @MappingTarget AsignacionEmpleadoZona asignacion);
    
    @Mapping(target = "idComprasGarages", ignore = true)
    @Mapping(target = "socio", source = "socio")
    @Mapping(target = "garage", source = "garage")
    void updateEntityFromDto(CompraGarageDTO dto, Socio socio, Garage garage, @MappingTarget CompraGarage compra);
    
    @Mapping(target = "idVehiculo", ignore = true)
    @Mapping(target = "tipoVehiculo", source = "tipo") 
    @Mapping(target = "socioDueño", source = "socio") 
    Vehiculo toEntity(VehiculoDTO dto, TipoVehiculo tipo, Socio socio);

    @Mapping(target = "idVehiculo", ignore = true)
    @Mapping(target = "tipoVehiculo", source = "tipo")
    @Mapping(target = "socioDueño", source = "socio")
    void updateEntityFromDto(VehiculoDTO dto, TipoVehiculo tipo, Socio socio, @MappingTarget Vehiculo vehiculo);

    
}
