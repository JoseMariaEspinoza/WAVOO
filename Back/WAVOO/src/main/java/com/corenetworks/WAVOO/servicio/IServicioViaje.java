package com.corenetworks.WAVOO.servicio;

import com.corenetworks.WAVOO.modelo.Viaje;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IServicioViaje extends ICRUD<Viaje,Integer> {
    List<Viaje> busquedaPrimeraTarjeta(String origen, String destino, LocalDate fechaInicio, LocalDate fechaFinal);
    List<Viaje> busquedaTarjetacompleta(String origen,String destino,LocalDate fechaInicio,LocalDate fechaFinal);
}