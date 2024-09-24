package com.corenetworks.WAVOO.servicio;

import com.corenetworks.WAVOO.modelo.Usuario;

public interface IServicioUsuario {
    Usuario consultarUno(String dni);
    Usuario crearUsuario(Usuario u);
    Usuario modificarUsuario(Usuario u);
    void suspenderCuenta(String dni);

}
