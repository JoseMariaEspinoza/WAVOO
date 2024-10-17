package com.corenetworks.WAVOO.repositorio;

import com.corenetworks.WAVOO.dto.FormularioUsuario;
import com.corenetworks.WAVOO.dto.impl.FormularioUsuarioDTO;
import com.corenetworks.WAVOO.dto.impl.UsuarioDTO;
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
                dni,
                contrasena,
                foto_usuario AS fotoUsuario,
                usuario
            FROM
                public.usuario
            WHERE
                dni = :dni AND
                usuario_activo = true;""", nativeQuery = true) // Filtrando solo usuarios activos
    Optional<UsuarioDTO> findUsuarioDTOByDni(@Param("dni") String dni);


}
