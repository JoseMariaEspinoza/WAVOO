package com.corenetworks.WAVOO.dto.impl;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CochesDTO {

    private String matricula;
    private String marca;
    private String modelo;
    private String carroceria;
    private int anio;
    private short numeroPlazas;
    private byte[] fotoCoche;
}
