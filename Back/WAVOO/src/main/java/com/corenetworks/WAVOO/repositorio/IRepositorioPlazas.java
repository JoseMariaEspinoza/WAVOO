package com.corenetworks.WAVOO.repositorio;

import com.corenetworks.WAVOO.modelo.Plazas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRepositorioPlazas extends IGenericRepo<Plazas,Integer> {
//    @Query(value = "SELECT * FROM plazas WHERE n_asiento = :nAsiento AND id_viaje = :idViaje;", nativeQuery = true)
//    Plazas obtenerPlazaPorAsientoYViaje(@Param("nAsiento")short nAsiento,@Param("idViaje") int idViaje);
}
