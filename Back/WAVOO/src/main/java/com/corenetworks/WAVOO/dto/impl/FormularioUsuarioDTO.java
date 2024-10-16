package com.corenetworks.WAVOO.dto.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FormularioUsuarioDTO {

    private String dni;
    private String contrasena;
    private String direccion;
    private String email;
    private LocalDate fechaNacimiento;
    private byte[] fotoUsuario;
    private String genero;
    private String nombreCompleto;
    private Boolean permisoConducir;
    @JsonProperty("rPreguntaSeguridad")
    private String rPreguntaSeguridad;
    private String telefono;
    private String usuario;

    private byte[] fotoCarnet;

    private String matricula;
    private int anio;
    private String carroceria;
    private byte[] fotoCoche;
    private String marca;
    private String modelo;
    private short numeroPlazas;
    private String cocheDni;

    @Override
    public String toString() {
        return "FormularioUsuarioDTO{" +
                "dni='" + dni + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fotoUsuario=" + Arrays.toString(fotoUsuario) +
                ", genero='" + genero + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", permisoConducir=" + permisoConducir +
                ", rPreguntaSeguridad='" + rPreguntaSeguridad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", usuario='" + usuario + '\'' +
                ", fotoCarnet=" + Arrays.toString(fotoCarnet) +
                ", matricula='" + matricula + '\'' +
                ", anio=" + anio +
                ", carroceria='" + carroceria + '\'' +
                ", fotoCoche=" + Arrays.toString(fotoCoche) +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", numeroPlazas=" + numeroPlazas +
                ", cocheDni='" + cocheDni + '\'' +
                '}';
    }
}
