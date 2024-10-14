package com.corenetworks.WAVOO.modelo;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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

    private byte[] fotoCoche;

    @ManyToOne
    @JoinColumn(name = "dni", foreignKey = @ForeignKey(name = "FK_coche_conductor"))
    private Conductor co1;



//    public Coche(String matricula, String marca, String modelo, String carroceria, int anio, short numeroPlazas, byte[] fotoCoche) {
//        this.matricula = matricula;
//        this.marca = marca;
//        this.modelo = modelo;
//        this.carroceria = carroceria;
//        this.anio = anio;
//        this.numeroPlazas = numeroPlazas;
//        this.fotoCoche = fotoCoche;
//    }

}
