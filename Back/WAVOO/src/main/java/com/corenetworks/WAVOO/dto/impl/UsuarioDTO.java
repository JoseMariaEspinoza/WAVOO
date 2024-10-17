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
    private String contrasena;
    private byte[] fotoUsuario;
    private String usuario;

}
