package com.corenetworks.WAVOO.dto;

public interface FormularioUsuario {
    // Métodos para obtener los datos del usuario
    String getUsuarioDni();
    String getContrasena();
    String getDireccion();
    String getEmail();
    java.util.Date getFechaNacimiento(); // Cambia el tipo según tu preferencia
    byte[] getFotoUsuario();
    String getGenero();
    String getNombreCompleto();
    boolean isPermisoConducir();
    String getRPreguntaSeguridad();
    String getTelefono();
    String getUsuarioNombre();

    // Métodos para obtener los datos del conductor
    String getConductorDni();
    byte[] getFotoCarnet();

    // Métodos para obtener los datos del coche
    String getMatricula();
    int getAnio();
    String getCarroceria();
    byte[] getFotoCoche();
    String getMarca();
    String getModelo();
    short getNumeroPlazas();
    String getCocheDni();
}
