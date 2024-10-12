package com.corenetworks.WAVOO.servicio;

import com.corenetworks.WAVOO.dto.BusquedaCompleta;
import com.corenetworks.WAVOO.dto.BusquedaInicial;
import com.corenetworks.WAVOO.modelo.Viaje;



import java.time.LocalDate;
import java.util.List;

public interface IServicioViaje extends ICRUD<Viaje,Integer> {
    List<BusquedaInicial> busquedaInicial(String origen,String destino,LocalDate fechaInicio,LocalDate fechaFinal,Short pDisponible);
    BusquedaCompleta busquedaCompleta(Integer id);

}