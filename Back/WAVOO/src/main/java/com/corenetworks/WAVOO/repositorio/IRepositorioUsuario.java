package com.corenetworks.WAVOO.repositorio;

import com.corenetworks.WAVOO.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorioUsuario extends IGenericRepo<Usuario,String> {
}
