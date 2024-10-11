package com.corenetworks.WAVOO.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public interface BusquedaInicial {
    // Métodos para obtener los datos del viaje
    int getIdViaje();
    String getOrigen();
    String getDestino();
    LocalDate getFecha(); // O usa java.time.LocalDate según necesites
    LocalTime getHora(); // O usa java.util.Date según necesites
    double getPrecio();
    short getPlazasDisponibles();

    // Métodos para obtener los datos del usuario
    String getDni();
    String getNombreCompleto();
    int getEdad(); // Edad calculada

    // Métodos para obtener los datos del coche
    byte[] getFotoCoche();
    String getMarca();
    String getModelo();
}

