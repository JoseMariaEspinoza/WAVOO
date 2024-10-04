package com.corenetworks.WAVOO.servicio;

import com.corenetworks.WAVOO.modelo.Viaje;

import java.time.LocalDate;
import java.util.List;

public interface IServicioViaje {
    List<Viaje> consultarOrigenDestinoFechaInicioYFin(String origen, String destino,
                                                      LocalDate fechaInicio, LocalDate fechaFinal);
    Viaje consultarUno(Integer id);
    Viaje crearViaje(Viaje v);
    Viaje modificar(Viaje v);
    void eliminarViaje(Integer id);
}
