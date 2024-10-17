package com.corenetworks.WAVOO.servicio.impl;

import com.corenetworks.WAVOO.dto.FormularioUsuario;
import com.corenetworks.WAVOO.dto.impl.FormularioUsuarioDTO;
import com.corenetworks.WAVOO.dto.impl.UsuarioDTO;
import com.corenetworks.WAVOO.excepciones.ExcepcionNoEncontradoModelo;
import com.corenetworks.WAVOO.modelo.Coche;
import com.corenetworks.WAVOO.modelo.Conductor;
import com.corenetworks.WAVOO.modelo.Usuario;
import com.corenetworks.WAVOO.repositorio.IGenericRepo;
import com.corenetworks.WAVOO.repositorio.IRepositorioCoche;
import com.corenetworks.WAVOO.repositorio.IRepositorioConductor;
import com.corenetworks.WAVOO.repositorio.IRepositorioUsuario;
import com.corenetworks.WAVOO.servicio.IServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ServicioUsuario extends CRUDImpl<Usuario,String> implements IServicioUsuario {
    @Autowired
    private IRepositorioUsuario repoUsuario;
    @Autowired
    private IRepositorioConductor repoConductor;
    @Autowired
    private IRepositorioCoche repoCoche;

    @Override
    protected IGenericRepo<Usuario, String> getRepo() {
        return repoUsuario;
    }

    @Override
    public FormularioUsuario editarPerfil(String dni) {
        return repoUsuario.editarPerfil(dni);
    }

    public void registrarConductor(Conductor conductor) {
        // Guardar el conductor en la base de datos
        repoConductor.save(conductor);
    }

    // Método para registrar un coche
    public void registrarCoche(Coche coche) {
        // Guardar el coche asociado a un conductor
        repoCoche.save(coche);
    }
    public UsuarioDTO verificarUsuario(String dni, String contrasena) {
        UsuarioDTO usuarioDTO = repoUsuario.findUsuarioDTOByDni(dni)
                .orElseThrow(() -> new ExcepcionNoEncontradoModelo("Usuario no encontrado con DNI: " + dni));

        if (!usuarioDTO.getContrasena().equals(contrasena)) {
            try {
                throw new Exception("Contraseña incorrecta");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return usuarioDTO;
    }
    public List<Coche> obtenerCochesPorConductor(String dni) {
        Usuario usuario = repoUsuario.findById(dni)
                .orElseThrow(() -> new ExcepcionNoEncontradoModelo("DNI no encontrado"));

        // Verificar si el usuario tiene permiso de conducir
        if (usuario.isPermisoConducir()) {
            // Si tiene permiso, obtener los coches asociados al conductor
            Conductor conductor = (Conductor) usuario;
            return conductor.getCoches(); // Asumiendo que 'Conductor' tiene un método getCoches
        }

        // Si no tiene permiso de conducir, devolver una lista vacía
        return new ArrayList<>();
    }


    @Override
    public Optional<Coche> buscarCochePorMatricula(String matricula) {
        return repoCoche.findByMatricula(matricula);
    }


}
