package com.corenetworks.WAVOO.dto.impl;

import com.corenetworks.WAVOO.modelo.Coche;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EditarUsuarioDTO {
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

    private List<CochesDTO> coches;
}
