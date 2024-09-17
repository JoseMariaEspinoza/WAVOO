package com.corenetworks.WAVOO.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "plazas")
public class Plazas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlaza;
    @Column(nullable = false)
    private short nAsiento;
    @ManyToOne
    @JoinColumn(name = "dni", nullable = false,
            foreignKey = @ForeignKey(name = "FK_plazas_usuario"))
    private Usuario u1;
    @ManyToOne
    @JoinColumn(name = "id_viaje", nullable = false,
            foreignKey = @ForeignKey(name = "FK_plazas_viaje"))
    private Viaje v1;
}
