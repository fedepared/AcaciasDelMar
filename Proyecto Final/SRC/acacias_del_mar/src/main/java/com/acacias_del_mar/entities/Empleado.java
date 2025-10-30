package com.acacias_del_mar.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data: Genera getters, setters, toString(), equals() y hashCode().
 * @NoArgsConstructor: Genera un constructor vacío (obligatorio para JPA).
 * @Entity: Marca esta clase como una entidad persistente.
 * @Table: Vincula la clase a la tabla "empleados".
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer idEmpleado;

    
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "apellido", length = 45)
    private String apellido;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "especialidad", length = 45)
    private String especialidad;
}

