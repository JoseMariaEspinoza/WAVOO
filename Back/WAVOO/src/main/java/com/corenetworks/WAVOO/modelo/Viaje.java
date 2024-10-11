package com.corenetworks.WAVOO.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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
    @Column(nullable = false)
    private LocalDate fecha;
    @Column(nullable = false)
    private LocalTime hora;

    @ManyToOne
    @JoinColumn(name = "matricula",foreignKey = @ForeignKey(name = "FK_viaje_coche"))
    private Coche c1;

    @OneToMany(mappedBy = "v1",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<Plazas> plazas = new ArrayList<>();

    public Viaje(String origen, String destino, short plazasDisponibles, double precio, LocalDate fecha, LocalTime hora, Coche c1) {
        this.origen = origen;
        this.destino = destino;
        this.plazasDisponibles = plazasDisponibles;
        this.precio = precio;
        this.fecha = fecha;
        this.hora = hora;
        this.c1 = c1;
    }

    @Override
    public String toString() {
        return "Viaje{" +
                "idViaje=" + idViaje +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", plazasDisponibles=" + plazasDisponibles +
                ", precio=" + precio +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", c1=" + c1 +
                ", plazas=" + plazas +
                '}';
    }
}
