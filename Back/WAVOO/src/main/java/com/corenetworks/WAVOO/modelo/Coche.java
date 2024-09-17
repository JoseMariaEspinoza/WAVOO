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
    @Column(length = 7)
    private String matricula;
    @Column(length = 20)
    private String marca;
    @Column(length = 20)
    private String modelo;
    @Column(length = 20)
    private String carroceria;
    private int anio;
    private short numeroPlazas;
    @ManyToOne
    @JoinColumn(name = "dni", nullable = false, foreignKey = @ForeignKey(name = "FK_coche_conductor"))
    private Conductor co1;
}
