package com.corenetworks.WAVOO.servicio.impl;

import com.corenetworks.WAVOO.excepciones.ExcepcionNoEncontradoModelo;
import com.corenetworks.WAVOO.modelo.Plazas;
import com.corenetworks.WAVOO.repositorio.IGenericRepo;
import com.corenetworks.WAVOO.repositorio.IRepositorioPlazas;
import com.corenetworks.WAVOO.repositorio.IRepositorioUsuario;
import com.corenetworks.WAVOO.servicio.IServicioPlazas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioPlazas extends CRUDImpl<Plazas ,Integer> implements IServicioPlazas {
    @Autowired
    private IRepositorioPlazas repoPlazas;

    @Autowired
    private IRepositorioUsuario repoUsuario;

    @Override
    protected IGenericRepo<Plazas, Integer> getRepo() {
        return repoPlazas;
    }

    public Plazas reservarPlaza (Plazas plazas) {
        Plazas pDisponible = repoPlazas.findById(plazas.getIdPlaza()).orElseThrow(() -> new ExcepcionNoEncontradoModelo("plaza no encontrada"));
        pDisponible.setU1(repoUsuario.findById(plazas.getU1().getDni()).orElseThrow(() -> new ExcepcionNoEncontradoModelo("usuario no encontrado")));
        return repoPlazas.save(plazas);

    }
}
