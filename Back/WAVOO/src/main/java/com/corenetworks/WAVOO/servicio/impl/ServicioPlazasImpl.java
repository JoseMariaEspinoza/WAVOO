package com.corenetworks.WAVOO.servicio.impl;

import com.corenetworks.WAVOO.modelo.Plazas;
import com.corenetworks.WAVOO.repositorio.IGenericRepo;
import com.corenetworks.WAVOO.repositorio.IRepositorioPlazas;
import com.corenetworks.WAVOO.servicio.IServicioPlazas;
import org.springframework.beans.factory.annotation.Autowired;

public class ServicioPlazasImpl extends CRUDImpl<Plazas ,Integer> implements IServicioPlazas {
    @Autowired
    private IRepositorioPlazas repoPlazas;

    @Override
    protected IGenericRepo<Plazas, Integer> getRepo() {
        return repoPlazas;
    }
}
