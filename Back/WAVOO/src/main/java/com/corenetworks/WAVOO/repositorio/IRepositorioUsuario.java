package com.corenetworks.WAVOO.repositorio;

import com.corenetworks.WAVOO.dto.FormularioUsuario;
import com.corenetworks.WAVOO.dto.IUsuario;
import com.corenetworks.WAVOO.modelo.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IRepositorioUsuario extends IGenericRepo<Usuario,String> {
    @Query(value = """
            SELECT
                  u.dni,
                  u.contrasena,
                  u.direccion,
                  u.email,
                  u.fecha_nacimiento,
                  u.foto_usuario,
                  u.genero,
                  u.nombre_completo,
                  u.permiso_conducir,
                  u.r_pregunta_seguridad,
                  u.telefono,
                  u.usuario,
                  c.foto_carnet,
                  array_agg(co.matricula) AS matriculas
              FROM public.usuario u
              LEFT JOIN public.conductor c ON u.dni = c.dni
              LEFT JOIN public.coche co ON c.dni = co.dni
              WHERE u.dni = :dni
              GROUP BY
                  u.dni,
                  u.contrasena,
                  u.direccion,
                  u.email,
                  u.fecha_nacimiento,
                  u.foto_usuario,
                  u.genero,
                  u.nombre_completo,
                  u.permiso_conducir,
                  u.r_pregunta_seguridad,
                  u.telefono,
                  u.usuario,
                  c.foto_carnet;""",nativeQuery = true)
    FormularioUsuario editarPerfil(@Param("dni")String dni);

    @Query(value = """
            SELECT
                u.dni,
                u.direccion,
                u.email,
                u.fecha_nacimiento,
                u.foto_usuario,
                u.genero,
                u.nombre_completo,
                u.permiso_conducir,
                u.r_pregunta_seguridad,
                u.telefono,
                u.usuario,
                c.foto_carnet,
                array_agg(co.matricula) AS matriculas
            FROM public.usuario u
            LEFT JOIN public.conductor c ON u.dni = c.dni
            LEFT JOIN public.coche co ON c.dni = co.dni
            WHERE u.dni = :dni AND
            u.contrasena = :contrasena
            GROUP BY
                u.dni,
                u.direccion,
                u.email,
                u.fecha_nacimiento,
                u.foto_usuario,
                u.genero,
                u.nombre_completo,
                u.permiso_conducir,
                u.r_pregunta_seguridad,
                u.telefono,
                u.usuario,
                c.foto_carnet;
            """, nativeQuery = true) // Filtrando solo usuarios activos
    FormularioUsuario identificacion(@Param("dni") String dni, @Param("contrasena") String contrasena);


}
