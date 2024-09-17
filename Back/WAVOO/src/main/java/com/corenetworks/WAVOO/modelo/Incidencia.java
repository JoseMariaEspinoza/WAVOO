package com.corenetworks.WAVOO.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "incidencia")
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIncidencia;
    @Column(nullable = false, length = 20)
    private String estado;
    @Column(nullable = false, length = 200)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_viaje", nullable = false,
            foreignKey = @ForeignKey(name = "FK_incidencia_viaje"))
    private Viaje v1;
    @ManyToOne
    @JoinColumn(name = "dni", nullable = false,
            foreignKey = @ForeignKey(name = "FK_incidencia_usuario"))
    private Usuario u1;
}
