package com.corenetworks.WAVOO.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FormularioUsuarioDTO {
    // Datos del usuario
    private String usuarioDni;
    private String contrasena;
    private String direccion;
    private String email;
    private Date fechaNacimiento; // Puedes cambiar a LocalDate si prefieres
    private byte[] fotoUsuario;
    private String genero;
    private String nombreCompleto;
    private boolean permisoConducir;
    private String rPreguntaSeguridad;
    private String telefono;
    private String usuarioNombre;

    // Datos del conductor
    private String conductorDni;
    private byte[] fotoCarnet;

    // Datos del coche
    private String matricula;
    private int anio;
    private String carroceria;
    private byte[] fotoCoche;
    private String marca;
    private String modelo;
    private short numeroPlazas;
    private String cocheDni;
}
