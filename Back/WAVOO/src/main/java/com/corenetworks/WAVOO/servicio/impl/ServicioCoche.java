package com.corenetworks.WAVOO.servicio.impl;

import com.corenetworks.WAVOO.dto.impl.CochesDTO;
import com.corenetworks.WAVOO.excepciones.ExcepcionNoEncontradoModelo;
import com.corenetworks.WAVOO.modelo.Coche;
import com.corenetworks.WAVOO.modelo.Conductor;
import com.corenetworks.WAVOO.repositorio.IGenericRepo;
import com.corenetworks.WAVOO.repositorio.IRepositorioCoche;
import com.corenetworks.WAVOO.repositorio.IRepositorioUsuario;
import com.corenetworks.WAVOO.servicio.IServicioCoche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioCoche extends CRUDImpl<Coche,String> implements IServicioCoche {
    @Autowired
    private IRepositorioCoche repoCoche;


    @Override
    protected IGenericRepo<Coche, String> getRepo() {
        return repoCoche;
    }

}
