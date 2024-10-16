package com.corenetworks.WAVOO.repositorio;

import com.corenetworks.WAVOO.dto.FormularioUsuario;
import com.corenetworks.WAVOO.modelo.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
               
                co.matricula,
                co.anio,
                co.carroceria,
                co.foto_coche,
                co.marca,
                co.modelo,
                co.numero_plazas
            FROM public.usuario u
            JOIN public.conductor c ON u.dni = c.dni
            JOIN public.coche co ON c.dni = co.dni
            WHERE u.dni = :dni;""",nativeQuery = true)
    FormularioUsuario editarPerfil(@Param("dni")String dni);

}
