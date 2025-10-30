package com.acacias_del_mar.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    /**
     * @Id y @GeneratedValue para la clave primaria AUTO_INCREMENT.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;

    /**
     * @Column(nullable = false): Coincide con el NOT NULL de la DB.
     */
    @Column(name = "matricula", nullable = false, length = 10)
    private String matricula;

    @Column(name = "marca", length = 45)
    private String marca;

    /**
     * Usamos 'Integer' (wrapper) para permitir valores nulos (DEFAULT NULL).
     */
    @Column(name = "profundidad")
    private Integer profundidad;

    @Column(name = "alto")
    private Integer alto;

    @Column(name = "ancho")
    private Integer ancho;

    /**
     * --- RELACIÓN 1: Clave Foránea a TipoVehiculo ---
     * @ManyToOne: Muchos vehículos pueden ser del mismo tipo.
     * @JoinColumn: Especifica la columna 'id_tipo_vehiculo' para esta relación.
     * (Asume que ya tienes una entidad 'TipoVehiculo').
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_vehiculo")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private TipoVehiculo tipoVehiculo;

    /**
     * --- RELACIÓN 2: Clave Foránea a Socio ---
     * @ManyToOne: Muchos vehículos pueden pertenecer al mismo socio.
     * @JoinColumn: Especifica la columna 'id_socio_dueño'.
     * 'nullable = false' coincide con el NOT NULL de la DB.
     * (Asume que ya tienes la entidad 'Socio' que creamos antes).
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_socio_dueño", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Socio socioDueño;
}
