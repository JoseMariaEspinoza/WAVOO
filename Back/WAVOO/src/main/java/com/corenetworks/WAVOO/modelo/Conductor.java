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
@Table(name = "conductor")
public class Conductor extends Usuario {
    @Column(nullable = false)
    private byte[] fotoCarnet;
    private boolean verificado;

    @OneToMany(mappedBy = "co1",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    List<Coche> coches;
}
