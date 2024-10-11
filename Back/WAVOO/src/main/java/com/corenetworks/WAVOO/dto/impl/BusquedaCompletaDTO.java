package com.corenetworks.WAVOO.dto.impl;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BusquedaCompletaDTO{

    private int idViaje;
    private String origen;
    private String destino;
    private LocalDate fecha;
    private LocalTime hora;
    private double precio;
    private short plazasDisponibles;

    private String dni;
    private String nombreCompleto;
    private byte[] fotoUsuario;
    private String telefono;
    private String genero;
    private int edad;

    private byte[] fotoCoche;
    private String marca;
    private String modelo;
    private String matricula;
    private String carroceria;
    private int anio;

    private List<Short> asientos;

}


