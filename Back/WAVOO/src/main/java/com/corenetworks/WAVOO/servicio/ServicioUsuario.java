package com.corenetworks.WAVOO.servicio;

import com.corenetworks.WAVOO.modelo.Usuario;
import com.corenetworks.WAVOO.repositorio.IRepositorioUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
public class ServicioUsuario implements IServicioUsuario{
    @Autowired
    private IRepositorioUsuario repoUsuario;

    @Override
    public Usuario consultarUno(String dni) {
        return repoUsuario.findById(dni).orElse(null);
    }

    @Override
    public Usuario crearUsuario(Usuario u) {
        return repoUsuario.save(u);
    }

    @Override
    public Usuario modificarUsuario(Usuario u) {
        return repoUsuario.save(u);
    }

    @Override
    public void suspenderCuenta(String dni) {
        repoUsuario.deleteById(dni);
    }
}
