package com.acacias_del_mar.DTOs;

import com.acacias_del_mar.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EntityMapper {

    //ENTIDAD -> DTO DE RESPUESTA
    
    // Entidades Simples
    EmpleadoResponseDTO toResponseDTO(Empleado empleado);
    SocioResponseDTO toResponseDTO(Socio socio);
    TipoVehiculoResponseDTO toResponseDTO(TipoVehiculo tipoVehiculo);

    // Entidades Anidadas (MapStruct las resuelve automáticamente)
    ZonaResponseDTO toResponseDTO(Zona zona);
    GarageResponseDTO toResponseDTO(Garage garage);
    VehiculoResponseDTO toResponseDTO(Vehiculo vehiculo);

    // Entidades de Unión (Junction)
    AsignacionResponseDTO toResponseDTO(Asignacion asignacion);
    AsignacionEmpleadoZonaResponseDTO toResponseDTO(AsignacionEmpleadoZona asignacion);
    CompraGarageResponseDTO toResponseDTO(CompraGarage compra);


    //2. DTO DE ENTRADA -> ENTIDAD (Para CREAR)
    
    @Mapping(target = "idEmpleado", ignore = true)
    Empleado toEntity(EmpleadoDTO dto);

    @Mapping(target = "idSocio", ignore = true)
    Socio toEntity(SocioDTO dto);

    @Mapping(target = "idVehiculo", ignore = true)
    @Mapping(target = "tipoVehiculo", source = "tipo")
    @Mapping(target = "socioDueño", source = "socio")
    Vehiculo toEntity(VehiculoDTO dto, TipoVehiculo tipo, Socio socio);
    
     @Mapping(target = "idZona", ignore = true)
    @Mapping(target = "letra", source = "dto.letra")
    @Mapping(target = "tipoVehiculo", source = "tipoVehiculo")
    @Mapping(target = "garages", ignore = true)
    Zona toEntity(ZonaDTO dto, TipoVehiculo tipoVehiculo);

    @Mapping(target = "idGarage", ignore = true)
    @Mapping(target = "zona", source = "zona") 
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


    // DTO DE ENTRADA -> ENTIDAD (Para ACTUALIZAR
    
    @Mapping(target = "idEmpleado", ignore = true)
    void updateEntityFromDto(EmpleadoDTO dto, @MappingTarget Empleado empleado);

    @Mapping(target = "idSocio", ignore = true)
    void updateEntityFromDto(SocioDTO dto, @MappingTarget Socio socio);
    
    @Mapping(target = "idVehiculo", ignore = true) 
    @Mapping(target = "tipoVehiculo", source = "tipo")
    @Mapping(target = "socioDueño", source = "socio")
    void updateEntityFromDto(VehiculoDTO dto, TipoVehiculo tipo, Socio socio, @MappingTarget Vehiculo vehiculo);

    @Mapping(target = "idZona", ignore = true)
    @Mapping(target = "letra", source = "dto.letra")
    @Mapping(target = "tipoVehiculo", source = "tipoVehiculo")
    @Mapping(target = "garages", ignore = true) // No actualizamos la lista desde aquí
    void updateEntityFromDto(ZonaDTO dto, TipoVehiculo tipoVehiculo, @MappingTarget Zona zona);
    
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

}
