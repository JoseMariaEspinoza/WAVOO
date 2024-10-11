package com.corenetworks.WAVOO.dto.impl;

import com.corenetworks.WAVOO.dto.BusquedaInicial;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BusquedaInicialDTO{
    // Datos del viaje
    private int idViaje;
    private String origen;
    private String destino;
    private LocalDate fecha;
    private LocalTime hora;
    private double precio;
    private short plazasDisponibles;

    // Datos del usuario
    private String dni;
    private String nombreCompleto;
    private int edad; // Edad calculada

    // Datos del coche
    private byte[] fotoCoche;
    private String marca;
    private String modelo;


}
