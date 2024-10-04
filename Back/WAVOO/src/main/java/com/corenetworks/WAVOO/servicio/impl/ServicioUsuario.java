package com.corenetworks.WAVOO.servicio.impl;

import com.corenetworks.WAVOO.modelo.Usuario;
import com.corenetworks.WAVOO.repositorio.IGenericRepo;
import com.corenetworks.WAVOO.repositorio.IRepositorioUsuario;
import com.corenetworks.WAVOO.servicio.ICRUD;
import com.corenetworks.WAVOO.servicio.IServicioUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
public class ServicioUsuario extends CRUDImpl<Usuario,String> implements IServicioUsuario {
    @Autowired
    private IRepositorioUsuario repoUsuario;

    @Override
    protected IGenericRepo<Usuario, String> getRepo() {
        return repoUsuario;
    }
}
