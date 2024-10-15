package com.corenetworks.WAVOO.dto.impl;

import com.corenetworks.WAVOO.modelo.Coche;
import com.corenetworks.WAVOO.modelo.Plazas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ViajeDTO {

    private int idViaje;
    private String origen;
    private String destino;
    private short plazasDisponibles;
    private double precio;
    private LocalDate fecha;
    private LocalTime hora;
    private String matricula;
}
