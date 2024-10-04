package com.corenetworks.WAVOO.repositorio;

import com.corenetworks.WAVOO.modelo.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IRepositorioViaje extends JpaRepository<Viaje,Integer> {
    @Query(value = "select * from viaje where origen= :origen, destino = :destino, fecha between :fechaInicio and :fechaFinal",
            nativeQuery = true)
    List<Viaje> consultarOrigenDestinoFechaInicioYFin(@Param("origen") String origen, @Param("destino") String destino,
                                                      @Param("fechaInicio") LocalDate fechaInicio,
                                                      @Param("fechaFinal") LocalDate fechaFinal);
}
