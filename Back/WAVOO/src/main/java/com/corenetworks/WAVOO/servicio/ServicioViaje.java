package com.corenetworks.WAVOO.servicio;

import com.corenetworks.WAVOO.modelo.Viaje;
import com.corenetworks.WAVOO.repositorio.IRepositorioViaje;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class ServicioViaje implements IServicioViaje{
    @Autowired
    private IRepositorioViaje repoViaje;

    @Override
    public List<Viaje> consultarOrigenDestinoFechaInicioYFin(String origen, String destino,
                                                             LocalDate fechaInicio, LocalDate fechaFinal) {
        return repoViaje.consultarOrigenDestinoFechaInicioYFin(origen,destino,fechaInicio,fechaFinal);
    }

    @Override
    public Viaje consultarUno(Integer id) {
        return repoViaje.findById(id).orElse(null);
    }

    @Override
    public Viaje crearViaje(Viaje v) {
        return repoViaje.save(v);
    }

    @Override
    public Viaje modificar(Viaje v) {
        return repoViaje.save(v);
    }

    @Override
    public void eliminarViaje(Integer id) {
        repoViaje.deleteById(id);
    }

}
