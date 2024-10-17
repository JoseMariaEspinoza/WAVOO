package com.corenetworks.WAVOO.dto;

import com.corenetworks.WAVOO.modelo.Coche;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface FormularioUsuario {
    // Métodos para obtener los datos del usuario
    String getDni();
    String getContrasena();
    String getDireccion();
    String getEmail();
    LocalDate getFechaNacimiento();
    byte[] getFotoUsuario();
    String getGenero();
    String getNombreCompleto();
    boolean isPermisoConducir();
    String getRPreguntaSeguridad();
    String getTelefono();
    String getUsuario();

    // Métodos para obtener los datos del conductor
    byte[] getFotoCarnet();

    // Métodos para obtener los datos del coche
    List<Coche> getCoches();
}
