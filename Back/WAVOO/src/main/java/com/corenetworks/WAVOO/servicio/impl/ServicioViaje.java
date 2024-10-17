package com.corenetworks.WAVOO.servicio.impl;

import com.corenetworks.WAVOO.dto.BusquedaCompleta;
import com.corenetworks.WAVOO.dto.BusquedaInicial;
import com.corenetworks.WAVOO.excepciones.ExcepcionNoEncontradoModelo;
import com.corenetworks.WAVOO.modelo.Coche;
import com.corenetworks.WAVOO.modelo.Conductor;
import com.corenetworks.WAVOO.modelo.Plazas;
import com.corenetworks.WAVOO.modelo.Viaje;
import com.corenetworks.WAVOO.repositorio.*;
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
    @Autowired
    private IRepositorioUsuario repoUsuario;
    @Autowired
    private IRepositorioPlazas repoPlazas;


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
        // Obtener el conductor por su DNI
        Conductor conductor = (Conductor) repoUsuario.findById(viaje.getC1().getCo1().getDni())
                .orElseThrow(() -> new ExcepcionNoEncontradoModelo("Conductor no encontrado"));

        // Verificar si el conductor tiene permiso de conducir y al menos un coche registrado
        if (!conductor.isPermisoConducir() || conductor.getCoches().isEmpty()) {
            try {
                throw new Exception("El usuario no es un conductor válido o no tiene coches registrados.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        // Crear tantas plazas como el número de asientos del coche
        short numeroPlazas = viaje.getC1().getNumeroPlazas();
        for (short i = 1; i <= numeroPlazas; i++) {
            Plazas plaza = new Plazas();
            plaza.setNAsiento(i); // Asignar número de asiento creciente
            viaje.agregarPlaza(plaza); // Añadir plaza al viaje
        }
        // Guardar el viaje en la base de datos
        return repoViaje.save(viaje);
    }
    public void eliminarViaje(int idViaje) {
        // Buscar el viaje por su ID
        Viaje viaje = repoViaje.findById(idViaje)
                .orElseThrow(() -> new ExcepcionNoEncontradoModelo("Viaje no encontrado"));

        // Eliminar las plazas asociadas al viaje
        if (!viaje.getPlazas().isEmpty()) {
            repoPlazas.deleteAll(viaje.getPlazas());
        }

        // Eliminar el viaje
        repoViaje.delete(viaje);
    }
}
