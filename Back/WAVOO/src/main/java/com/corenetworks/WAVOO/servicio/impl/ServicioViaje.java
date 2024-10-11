package com.corenetworks.WAVOO.servicio.impl;

import com.corenetworks.WAVOO.dto.BusquedaCompleta;
import com.corenetworks.WAVOO.dto.BusquedaInicial;
import com.corenetworks.WAVOO.modelo.Viaje;
import com.corenetworks.WAVOO.repositorio.IGenericRepo;
import com.corenetworks.WAVOO.repositorio.IRepositorioViaje;
import com.corenetworks.WAVOO.servicio.IServicioViaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioViaje extends CRUDImpl<Viaje,Integer> implements IServicioViaje {

    @Autowired
    private IRepositorioViaje repoViaje;

    @Override
    public BusquedaCompleta busquedaCompleta(Integer id) {
        return repoViaje.busquedaCompleta(id);
    }

    @Override
    protected IGenericRepo<Viaje, Integer> getRepo() {
        return repoViaje;
    }

    @Override
    public List<BusquedaInicial> busquedaInicial(String origen, String destino, LocalDate fechaInicio, LocalDate fechaFinal, Short pDisponible) {
        return repoViaje.busquedaInicial(origen, destino, fechaInicio, fechaFinal, pDisponible);
    }
}
