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
@Table(name = "asignaciones_empleado_zona")
public class AsignacionEmpleadoZona {

    /**
     * @Id y @GeneratedValue para la clave primaria AUTO_INCREMENT.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignacion_empleado_zona")
    private Integer idAsignacionEmpleadoZona;

    /**
     * --- RELACIÓN 1: Clave Foránea a Empleado ---
     * @ManyToOne: Muchas asignaciones apuntan a UN empleado.
     * @JoinColumn: Especifica la columna 'id_empleado'.
     * 'nullable = false' coincide con el NOT NULL.
     * (Asume que tienes la entidad 'Empleado').
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Empleado empleado;

    /**
     * --- RELACIÓN 2: Clave Foránea a Zona ---
     * @ManyToOne: Muchas asignaciones apuntan a UNA zona.
     * @JoinColumn: Especifica la columna 'id_zona'.
     * 'nullable = false' coincide con el NOT NULL.
     * (Asume que tienes la entidad 'Zona').
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_zona", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Zona zona;
}
