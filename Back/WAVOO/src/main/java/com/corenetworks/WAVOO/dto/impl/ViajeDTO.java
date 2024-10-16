package com.corenetworks.WAVOO.dto.impl;

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
public class ViajeDTO {

    private int idViaje;
    private String origen;
    private String destino;
    private double precio;
    private LocalDate fecha;
    private LocalTime hora;
    private String matricula;
}
