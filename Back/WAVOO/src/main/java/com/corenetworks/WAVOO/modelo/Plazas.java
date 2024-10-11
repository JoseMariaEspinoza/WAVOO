package com.corenetworks.WAVOO.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "plazas")
public class Plazas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlaza;
    @Column(nullable = false)
    private short nAsiento;
    @ManyToOne
    @JoinColumn(name = "dni",
            foreignKey = @ForeignKey(name = "FK_plazas_usuario"))
    private Usuario u1;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_viaje",
            foreignKey = @ForeignKey(name = "FK_plazas_viaje"))
    private Viaje v1;

    public Plazas(short nAsiento, Usuario u1, Viaje v1) {
        this.nAsiento = nAsiento;
        this.u1 = u1;
        this.v1 = v1;
    }

    @Override
    public String toString() {
        return "Plazas{" +
                "idPlaza=" + idPlaza +
                ", nAsiento=" + nAsiento +
                ", u1=" + u1 +
                ", v1=" + v1 +
                '}';
    }
}
