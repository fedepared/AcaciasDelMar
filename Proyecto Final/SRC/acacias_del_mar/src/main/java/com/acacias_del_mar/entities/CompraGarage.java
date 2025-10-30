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
@Table(name = "compras_garages")
public class CompraGarage {

    /**
     * @Id y @GeneratedValue para la clave primaria AUTO_INCREMENT.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compras_garages")
    private Integer idComprasGarages;

    /**
     * --- RELACIÓN 1: Clave Foránea a Socio ---
     * @ManyToOne: Muchas compras pueden ser hechas por UN socio.
     * @JoinColumn: Especifica la columna 'id_socio'.
     * 'nullable = false' coincide con el NOT NULL.
     * (Asume que tienes la entidad 'Socio').
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_socio", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Socio socio;

    /**
     * --- RELACIÓN 2: Clave Foránea a Garage ---
     * @ManyToOne: Muchas compras pueden apuntar a UN garage.
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
     * 'nullable = false' coincide con el NOT NULL.
     */
    @Column(name = "fecha_compra", nullable = false)
    private LocalDate fechaCompra;
}