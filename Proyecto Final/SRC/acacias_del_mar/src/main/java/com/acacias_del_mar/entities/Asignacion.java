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
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "asignaciones")
public class Asignacion {

    /**
     * @Id y @GeneratedValue para la clave primaria AUTO_INCREMENT.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignacion")
    private Integer idAsignacion;

    /**
     * --- RELACIÓN 1: Clave Foránea a Vehiculo ---
     * @ManyToOne: Muchas asignaciones apuntan a UN vehículo.
     * @JoinColumn: Especifica la columna 'id_vehiculo'.
     * 'nullable = false' coincide con el NOT NULL.
     * (Asume que tienes la entidad 'Vehiculo').
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehiculo", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Vehiculo vehiculo;

    /**
     * --- RELACIÓN 2: Clave Foránea a Garage ---
     * @ManyToOne: Muchas asignaciones apuntan a UN garage.
     * @JoinColumn: Especifica la columna 'id_garage'.
     * 'nullable = false' coincide con el NOT NULL.
     * (Asume que tienes la entidad 'Garage').
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_garage", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Garage garage;

    /**
     * El tipo 'date' de SQL se mapea a 'java.time.LocalDate'.
     * Permite nulos (DEFAULT NULL).
     */
    @Column(name = "fecha_asignacion")
    private LocalDate fechaAsignacion;
}
