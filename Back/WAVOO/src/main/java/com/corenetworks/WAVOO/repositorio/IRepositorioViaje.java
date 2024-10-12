package com.corenetworks.WAVOO.repositorio;

import com.corenetworks.WAVOO.dto.BusquedaCompleta;

import com.corenetworks.WAVOO.dto.BusquedaInicial;
import com.corenetworks.WAVOO.modelo.Viaje;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IRepositorioViaje extends IGenericRepo<Viaje,Integer> {

    @Query(value = """
                SELECT v.id_viaje,
                v.origen,
                v.destino,
                v.fecha,
                v.hora,
                v.precio,
                v.plazas_disponibles,
                u.dni,
                u.nombre_completo,
                EXTRACT(YEAR FROM AGE(u.fecha_nacimiento)) AS edad,
                c.foto_coche,
                c.marca,
                c.modelo
            FROM viaje v
            JOIN coche c ON v.matricula = c.matricula
            JOIN conductor d ON c.dni = d.dni
            JOIN usuario u ON d.dni = u.dni
            WHERE v.origen = :origen
                AND v.destino = :destino
                AND v.fecha BETWEEN :fechaInicio AND :fechaFinal
                AND v.plazas_disponibles >= :pDisponible;""", nativeQuery = true)
    List<BusquedaInicial> busquedaInicial(@Param("origen") String origen,
                                          @Param("destino") String destino,
                                          @Param("fechaInicio") LocalDate fechaInicio,
                                          @Param("fechaFinal") LocalDate fechaFinal,
                                          @Param("pDisponible") Short pDisponible);
    @Query(value = """
            SELECT v.id_viaje,
                   v.origen,
                   v.destino,
                   v.fecha,
                   v.hora,
                   v.precio,
                   v.plazas_disponibles,
                   u.dni,
                   u.nombre_completo,
                   u.foto_usuario,
                   u.telefono,
                   u.genero,
                   EXTRACT(YEAR FROM AGE(u.fecha_nacimiento)) AS edad,
                   c.foto_coche,
                   c.marca,
                   c.modelo,
                   c.matricula,
                   c.carroceria,
                   c.anio,
                   array_agg(p.n_asiento) AS asientos
            FROM viaje v
            JOIN coche c ON v.matricula = c.matricula
            JOIN plazas p ON v.id_viaje = p.id_viaje
            JOIN conductor con ON c.dni = con.dni
            JOIN usuario u ON con.dni = u.dni
            WHERE v.id_viaje = :idViaje
            GROUP BY v.id_viaje,u.dni,c.foto_coche,c.marca,c.modelo,c.matricula;""", nativeQuery = true)
    BusquedaCompleta busquedaCompleta(@Param("idViaje") Integer id);
}
