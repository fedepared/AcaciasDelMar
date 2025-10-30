package com.acacias_del_mar.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

/**
 * @Data: Genera getters, setters, toString(), etc.
 * @NoArgsConstructor: Constructor vacío requerido por JPA.
 * @Entity: Marca la clase como entidad.
 * @Table: Vincula a la tabla "socios".
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "socios")
public class Socio {

    /**
     * @Id y @GeneratedValue para la clave primaria AUTO_INCREMENT.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_socio")
    private Integer idSocio;

    /**
     * @Column(nullable = false): Coincide con el NOT NULL de la DB.
     */
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 25)
    private String apellido;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "telefono", length = 16)
    private String telefono;

    /**
     * El tipo 'date' de SQL se mapea a 'java.time.LocalDate'.
     * Esta clase no incluye información de hora, solo día, mes y año.
     * 'nullable = false' coincide con el NOT NULL.
     */
    @Column(name = "fecha_de_ingreso", nullable = false)
    private LocalDate fechaDeIngreso;
}
