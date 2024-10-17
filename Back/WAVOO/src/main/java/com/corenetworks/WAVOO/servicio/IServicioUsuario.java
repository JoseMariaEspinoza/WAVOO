package com.corenetworks.WAVOO.servicio;

import com.corenetworks.WAVOO.dto.FormularioUsuario;
import com.corenetworks.WAVOO.dto.impl.UsuarioDTO;
import com.corenetworks.WAVOO.modelo.Coche;
import com.corenetworks.WAVOO.modelo.Conductor;
import com.corenetworks.WAVOO.modelo.Usuario;

import java.util.List;
import java.util.Optional;

public interface IServicioUsuario extends ICRUD<Usuario,String> {
    FormularioUsuario editarPerfil(String dni);
    void registrarConductor(Conductor conductor);
    void registrarCoche(Coche coche);
    UsuarioDTO verificarUsuario(String dni, String contrasena);
    List<Coche> obtenerCochesPorConductor(String dniConductor);
    Optional<Coche> buscarCochePorMatricula(String matricula);
}
