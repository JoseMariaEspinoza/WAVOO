package com.corenetworks.WAVOO.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "conductor")
public class Conductor extends Usuario {

    private byte[] fotoCarnet;
    private boolean verificado;

//    @OneToMany(mappedBy = "co1",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.EAGER)
//    private List<Coche> coches = new ArrayList<>();

    public Conductor(String dni, String nombreCompleto, String direccion, LocalDate fechaNacimiento, String email, String usuario, String contrasena, int telefono, char genero, short rango, boolean permisoConducir, short nivelAcceso, byte[] fotoUsuario, String rPreguntaSeguridad, boolean usuarioActivo, byte[] fotoCarnet, boolean verificado) {
        super(dni, nombreCompleto, direccion, fechaNacimiento, email, usuario, contrasena, telefono, genero, rango, permisoConducir, nivelAcceso, fotoUsuario, rPreguntaSeguridad, usuarioActivo);
        this.fotoCarnet = fotoCarnet;
        this.verificado = verificado;
    }

}
