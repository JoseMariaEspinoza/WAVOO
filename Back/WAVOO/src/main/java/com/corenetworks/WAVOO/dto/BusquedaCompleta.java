package com.corenetworks.WAVOO.dto;

import com.corenetworks.WAVOO.dto.impl.PlazaInfoDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface BusquedaCompleta{
    // Métodos para obtener los datos del viaje
    int getIdViaje();
    String getOrigen();
    String getDestino();
    LocalDate getFecha(); // Cambia el tipo según tu preferencia
    LocalTime getHora(); // O usa java.util.Date según necesites
    double getPrecio();
    short getPlazasDisponibles();

    // Métodos para obtener los datos del usuario
    String getDni();
    String getNombreCompleto();
    byte[] getFotoUsuario();
    String getTelefono();
    String getGenero();
    int getEdad(); // La edad calculada desde la fecha de nacimiento

    // Métodos para obtener los datos del coche
    byte[] getFotoCoche();
    String getMarca();
    String getModelo();
    String getMatricula();
    String getCarroceria();
    int getAnio();

    // Métodos para obtener los datos de las plazas
    List<PlazaInfoDTO> getPlazas();
}
