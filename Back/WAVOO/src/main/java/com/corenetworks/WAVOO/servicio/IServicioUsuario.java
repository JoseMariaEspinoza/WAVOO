package com.corenetworks.WAVOO.servicio;

import com.corenetworks.WAVOO.dto.FormularioUsuario;
import com.corenetworks.WAVOO.modelo.Usuario;

public interface IServicioUsuario extends ICRUD<Usuario,String> {
    FormularioUsuario editarPerfil(String dni);

}
