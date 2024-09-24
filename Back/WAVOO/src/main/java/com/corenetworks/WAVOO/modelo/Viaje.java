package com.corenetworks.WAVOO.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "viaje")
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idViaje;
    @Column(length = 20, nullable = false)
    private String origen;
    @Column(length = 20, nullable = false)
    private String destino;
    @Column(nullable = false)
    private short plazasDisponibles;
    @Column(nullable = false)
    private double precio;
    @ManyToOne
    @JoinColumn(name = "matricula", nullable = false,foreignKey = @ForeignKey(name = "FK_viaje_coche"))
    private Coche c1;

    @OneToMany(mappedBy = "v1",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    List<Plazas> plazas;
}
