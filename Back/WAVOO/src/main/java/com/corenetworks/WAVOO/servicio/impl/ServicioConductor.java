package com.corenetworks.WAVOO.servicio.impl;

import com.corenetworks.WAVOO.modelo.Conductor;
import com.corenetworks.WAVOO.repositorio.IGenericRepo;
import com.corenetworks.WAVOO.repositorio.IRepositorioConductor;
import com.corenetworks.WAVOO.servicio.IServicioConductor;
import org.springframework.beans.factory.annotation.Autowired;

public class ServicioConductor extends CRUDImpl<Conductor,String> implements IServicioConductor {
    @Autowired
    private IRepositorioConductor repoConductor;

    @Override
    protected IGenericRepo<Conductor, String> getRepo() {
        return repoConductor;
    }
}
