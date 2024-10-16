package com.corenetworks.WAVOO.servicio.impl;

import com.corenetworks.WAVOO.dto.BusquedaCompleta;
import com.corenetworks.WAVOO.dto.BusquedaInicial;
import com.corenetworks.WAVOO.modelo.Coche;
import com.corenetworks.WAVOO.modelo.Plazas;
import com.corenetworks.WAVOO.modelo.Viaje;
import com.corenetworks.WAVOO.repositorio.IGenericRepo;
import com.corenetworks.WAVOO.repositorio.IRepositorioCoche;
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
    @Autowired
    private IRepositorioCoche repoCoche;

    @Override
    public List<BusquedaInicial> busquedaInicial(String origen, String destino, LocalDate fechaInicio, LocalDate fechaFinal, Short pDisponible) {
        return repoViaje.busquedaInicial(origen, destino, fechaInicio, fechaFinal, pDisponible);
    }

    @Override
    public BusquedaCompleta busquedaCompleta(Integer id) {
        return repoViaje.busquedaCompleta(id);
    }

    @Override
    protected IGenericRepo<Viaje, Integer> getRepo() {
        return repoViaje;
    }

    public Viaje darDeAltaViaje(Viaje viaje) {
        // Crear tantas plazas como el número de asientos del coche
        short numeroPlazas = viaje.getC1().getNumeroPlazas();
        for (short i = 1; i <= numeroPlazas; i++) {
            Plazas plaza = new Plazas();
            plaza.setNAsiento(i); // Asignar número de asiento creciente
            viaje.agregarPlaza(plaza); // Añadir plaza al viaje
            viaje.setPlazasDisponibles(numeroPlazas);
        }
        // Guardar el viaje en la base de datos
        return repoViaje.save(viaje);
    }
}
