package com.corenetworks.WAVOO.repositorio;

import com.corenetworks.WAVOO.modelo.Coche;

import java.util.Optional;

public interface IRepositorioCoche extends IGenericRepo<Coche,String>{
    Optional<Coche> findByMatricula(String matricula);
}
