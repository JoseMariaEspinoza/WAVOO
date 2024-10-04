package com.corenetworks.WAVOO.servicio;

import com.corenetworks.WAVOO.modelo.Conductor;

public interface IServicioConductor {
    Conductor consultarUno(String dni);
    Conductor crearConductor(Conductor u);
    Conductor modificarConductor(Conductor u);
    void suspenderCuenta(String dni);
}
