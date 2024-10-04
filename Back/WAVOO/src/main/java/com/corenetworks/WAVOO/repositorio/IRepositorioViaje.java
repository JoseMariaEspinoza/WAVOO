package com.corenetworks.WAVOO.repositorio;

import com.corenetworks.WAVOO.modelo.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IRepositorioViaje extends IGenericRepo<Viaje,Integer> {
    @Query(value = """
            SELECT v.id_viaje, v.origen, v.destino, v.fecha, v.hora, v.precio, v.plazas_disponibles, u.dni, u.nombre_completo,
            EXTRACT(YEAR FROM AGE(u.fecha_nacimiento)) AS edad, c.foto_coche, c.marca, c.modelo FROM viaje v
            JOIN coche c ON v.matricula = c.matricula JOIN conductor con ON c.dni = con.dni JOIN usuario u ON con.dni = u.dni
            WHERE origen= :origen, destino = :destino, fecha between :fechaInicio and :fechaFinal""",
            nativeQuery = true)
    List<Viaje> busquedaPrimeraTarjeta(@Param("origen") String origen, @Param("destino") String destino,
                                                      @Param("fechaInicio") LocalDate fechaInicio,
                                                      @Param("fechaFinal") LocalDate fechaFinal);
    @Query(value = """
            SELECT v.id_viaje, v.origen, v.destino, v.fecha, v.hora, v.precio, v.plazas_disponibles,\s
            u.dni, u.nombre_completo, u.foto_usuario, u.telefono, u.genero, EXTRACT(YEAR FROM AGE(u.fecha_nacimiento)) AS edad,\s
            c.foto_coche, c.marca, c.modelo, c.matricula, c.carroceria, c.anio, p.n_asiento FROM viaje v\s
            JOIN coche c ON v.matricula = c.matricula JOIN plazas p ON v.id_viaje = p.id_viaje JOIN conductor con ON c.dni = con.dni JOIN usuario u\s
            ON con.dni = u.dni
            WHERE origen= :origen, destino = :destino, fecha between :fechaInicio and :fechaFinal""",
            nativeQuery = true)
    List<Viaje> busquedaTarjetacompleta(@Param("origen") String origen, @Param("destino") String destino,
                                        @Param("fechaInicio") LocalDate fechaInicio,
                                        @Param("fechaFinal") LocalDate fechaFinal);
}
