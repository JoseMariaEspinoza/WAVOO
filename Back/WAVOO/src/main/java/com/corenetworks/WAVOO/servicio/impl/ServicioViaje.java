package com.corenetworks.WAVOO.servicio.impl;

import com.corenetworks.WAVOO.modelo.Viaje;
import com.corenetworks.WAVOO.repositorio.IGenericRepo;
import com.corenetworks.WAVOO.repositorio.IRepositorioViaje;
import com.corenetworks.WAVOO.servicio.IServicioViaje;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class ServicioViaje extends CRUDImpl<Viaje,Integer> implements IServicioViaje {
    @Autowired
    private IRepositorioViaje repoViaje;


    @Override
    public List<Viaje> busquedaPrimeraTarjeta(String origen, String destino, LocalDate fechaInicio, LocalDate fechaFinal) {
        return repoViaje.busquedaPrimeraTarjeta(origen, destino, fechaInicio, fechaFinal);
    }

    @Override
    public List<Viaje> busquedaTarjetacompleta(String origen, String destino, LocalDate fechaInicio, LocalDate fechaFinal) {
        return repoViaje.busquedaTarjetacompleta(origen, destino, fechaInicio, fechaFinal);
    }

    @Override
    protected IGenericRepo<Viaje, Integer> getRepo() {
        return repoViaje;
    }
}
