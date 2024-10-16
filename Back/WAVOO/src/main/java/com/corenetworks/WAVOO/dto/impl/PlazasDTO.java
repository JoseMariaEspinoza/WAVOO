package com.corenetworks.WAVOO.dto.impl;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PlazasDTO {

    private List<Integer> idPlaza;
    private String dni;
    private int idViaje;
}
