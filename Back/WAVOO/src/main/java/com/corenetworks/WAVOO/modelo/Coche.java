package com.corenetworks.WAVOO.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "coche")
public class Coche {
    @Id
    @Column(length = 7,nullable = false)
    private String matricula;
    @Column(length = 20,nullable = false)
    private String marca;
    @Column(length = 20,nullable = false)
    private String modelo;
    @Column(length = 20,nullable = false)
    private String carroceria;
    @Column(nullable = false)
    private int anio;
    @Column(nullable = false)
    private short numeroPlazas;
    @Column(nullable = false)
    private byte[] fotoCoche;

    @ManyToOne
    @JoinColumn(name = "dni", nullable = false, foreignKey = @ForeignKey(name = "FK_coche_conductor"))
    private Conductor co1;
}
