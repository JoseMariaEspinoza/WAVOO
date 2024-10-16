package com.corenetworks.WAVOO.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(length = 9, nullable = false)
    private String dni;
    @Column(length = 40, nullable = false)
    private String nombreCompleto;
    @Column(length = 60, nullable = false)
    private String direccion;
    @Column(length = 10, nullable = false)
    private LocalDate fechaNacimiento;
    @Column(length = 50, nullable = false)
    private String email;
    @Column(length = 10, nullable = false)
    private String usuario;
    @Column(length = 8, nullable = false)
    private String contrasena;
    @Column(length = 11, nullable = false)
    private int telefono;
    @Column(length = 1, nullable = false)
    private char genero;
    private boolean permisoConducir = false;
    @Column(nullable = false)
    private short nivelAcceso = 1;

    private byte[] fotoUsuario;
    @Column(length = 40, nullable = false)
    private String rPreguntaSeguridad;
    private boolean usuarioActivo = false;

    @Override
    public String toString() {
        return "Usuario{" +
                "dni='" + dni + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", email='" + email + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", telefono=" + telefono +
                ", genero=" + genero +
                ", permisoConducir=" + permisoConducir +
                ", nivelAcceso=" + nivelAcceso +
                ", fotoUsuario=" + Arrays.toString(fotoUsuario) +
                ", rPreguntaSeguridad='" + rPreguntaSeguridad + '\'' +
                ", usuarioActivo=" + usuarioActivo +
                '}';
    }
}
