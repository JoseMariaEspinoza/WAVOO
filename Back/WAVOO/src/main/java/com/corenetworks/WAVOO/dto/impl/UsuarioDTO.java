package com.corenetworks.WAVOO.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UsuarioDTO {
    private String dni;
    private String nombreCompleto;
    private String direccion;
    private LocalDate fechaNacimiento;
    private String email;
    private String usuario;
    private String contrasena;
    private int telefono;
    private char genero;
    private boolean permisoConducir = false;
    private byte[] fotoUsuario;
    private String rPreguntaSeguridad;
}
