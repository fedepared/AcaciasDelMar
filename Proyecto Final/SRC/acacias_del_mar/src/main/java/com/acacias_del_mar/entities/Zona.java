package com.acacias_del_mar.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@Entity
@Table(name = "zonas")

//para ignorar el lazy loading y los problemas de relaciones many to one
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Zona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona")
    private Integer idZona;

    
    @Column(name = "letra", length = 1)
    private char letra;

    
    @Column(name = "profundidad")
    private Integer profundidad;

    @Column(name = "ancho")
    private Integer ancho;

    /**
     * --- RELACIÓN MANY-TO-ONE ---
     * Mapeo de la clave foránea 'id_tipo_vehiculo'.
     * Muchas zonas pueden tener el mismo tipo de vehículo.
     * Asume que tienes una entidad 'TipoVehiculo'.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_vehiculo")
    @ToString.Exclude // Ver nota abajo
    @EqualsAndHashCode.Exclude // Ver nota abajo
    private TipoVehiculo tipoVehiculo;

    /**
     * --- RELACIÓN ONE-TO-MANY (INVERSA) ---
     * Esta es la contraparte de la relación en tu clase 'Garage'.
     * 'mappedBy = "zona"' le dice a JPA que el campo 'zona' 
     * en la entidad 'Garage' es el dueño de esta relación.
     */
    @OneToMany(mappedBy = "zona")
    @ToString.Exclude 
    @EqualsAndHashCode.Exclude
    //Las anotaciones @ToString.Exclude y @EqualsAndHashCode.Exclude 
    //es para que Lombok ignore estos campos al generar esos métodos, rompiendo el ciclo infinito.
    @JsonManagedReference
    private Set<Garage> garages = new HashSet<>();

}
