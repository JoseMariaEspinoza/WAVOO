package com.corenetworks.WAVOO.repositorio;

import com.corenetworks.WAVOO.modelo.Plazas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRepositorioPlazas extends IGenericRepo<Plazas,Integer> {
}
