package com.corenetworks.WAVOO.servicio.impl;

import com.corenetworks.WAVOO.modelo.Coche;
import com.corenetworks.WAVOO.repositorio.IGenericRepo;
import com.corenetworks.WAVOO.repositorio.IRepositorioCoche;
import com.corenetworks.WAVOO.servicio.IServicioCoche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioCoche extends CRUDImpl<Coche,String> implements IServicioCoche {
    @Autowired
    private IRepositorioCoche repoCoche;

    @Override
    protected IGenericRepo<Coche, String> getRepo() {
        return repoCoche;
    }
}
