package com.corenetworks.WAVOO.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "conductor")
public class Conductor extends Usuario {
    @Column(nullable = false)
    private byte[] fotoCarnet;
    private boolean verificado;
}
