package com.acacias_del_mar.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

/**
 * @Data: Genera getters, setters, toString(), etc.
 * @NoArgsConstructor: Constructor vacío requerido por JPA.
 * @Entity: Marca la clase como entidad de base de datos.
 * @Table: Vincula a la tabla "garages".
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "garages")
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_garage")
    private Integer idGarage;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    
    @Column(name = "lectura_contador_luz")
    private Integer lecturaContadorLuz;

    @Column(name = "tiene_servicios_contratados", nullable = false)
    private boolean tieneServiciosContratados;

    /**
     * --- MAPEJO DE CLAVE FORÁNEA ---
     * @ManyToOne: Define la relación (Muchos Garages pertenecen a Una Zona).
     * @JoinColumn(name = "id_zona"):
     * Esta es la anotación le dice a JPA que esta relación
     * se gestiona a través de la columna 'id_zona' en la tabla 'garages'.
     * (FetchType.LAZY es una buena práctica para que no cargue la Zona
     * a menos que la pidas explícitamente con garage.getZona()).
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_zona")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Zona zona; // <-- Mapeamos el objeto completo, no solo el ID
}