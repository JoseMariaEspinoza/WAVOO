package com.corenetworks.WAVOO.controlador;

import com.corenetworks.WAVOO.dto.impl.FormularioUsuarioDTO;
import com.corenetworks.WAVOO.excepciones.ExcepcionNoEncontradoModelo;
import com.corenetworks.WAVOO.modelo.Coche;
import com.corenetworks.WAVOO.modelo.Conductor;
import com.corenetworks.WAVOO.modelo.Usuario;
import com.corenetworks.WAVOO.servicio.IServicioUsuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private IServicioUsuario servicioUsuario;

    @Autowired
    private ModelMapper mapper;

    // Búsqueda de usuarios por nombre y correo
//    @GetMapping("/{nombre}/{correo}")
//    public ResponseEntity<List<FormularioUsuarioDTO>> buscarUsuarios(@PathVariable("nombre") String nombre,
//                                                                     @PathVariable("correo") String correo) throws Exception {
//
//        List<FormularioUsuarioDTO> resultado = servicioUsuario.buscarPorNombreYCorreo(nombre, correo)
//                .stream().map(x -> mapper.map(x, FormularioUsuarioDTO.class))
//                .collect(Collectors.toList());
//        return new ResponseEntity<>(resultado, HttpStatus.OK);
//    }

    // Obtener un usuario por su ID
//    @GetMapping("/{idUsuario}")
//    public ResponseEntity<FormularioUsuarioDTO> consultarUno(@PathVariable("idUsuario") String idUsuario) throws Exception {
//        Usuario usuario = servicioUsuario.listarPorId(idUsuario);
//        if (usuario == null) {
//            throw new ExcepcionNoEncontradoModelo("ID No encontrado " + idUsuario);
//        }
//        FormularioUsuarioDTO dtoResponse = mapper.map(usuario, FormularioUsuarioDTO.class);
//        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
//    }
//
//    // Registrar un nuevo usuario
//    @PostMapping
//    public ResponseEntity<FormularioUsuarioDTO> insertar(@Validated @RequestBody FormularioUsuarioDTO formularioUsuario) throws Exception {
//        Usuario usuario = mapper.map(formularioUsuario, Usuario.class);
//        FormularioUsuarioDTO dtoResponse = mapper.map(servicioUsuario.registrar(usuario), FormularioUsuarioDTO.class);
//        return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }

    // Modificar un usuario existente
//    @PutMapping
//    public ResponseEntity<FormularioUsuarioDTO> modificar(@Validated @RequestBody FormularioUsuarioDTO usuarioDTO) throws Exception {
//        Usuario usuario = mapper.map(usuarioDTO, Usuario.class);
//        Usuario usuarioExistente = servicioUsuario.listarPorId(usuario.getIdUsuario());
//        if (usuarioExistente == null) {
//            throw new ExcepcionNoEncontradoModelo("ID No encontrado " + usuario.getIdUsuario());
//        }
//        return new ResponseEntity<>(mapper.map(servicioUsuario.modificar(usuario), FormularioUsuarioDTO.class), HttpStatus.OK);
//    }

    // Eliminar un usuario por su ID
//    @DeleteMapping("/{idUsuario}")
//    public ResponseEntity<Void> eliminar(@PathVariable("idUsuario") int idUsuario) throws Exception {
//        Usuario usuarioExistente = servicioUsuario.listarPorId(idUsuario);
//        if (usuarioExistente == null) {
//            throw new ExcepcionNoEncontradoModelo("ID No encontrado " + idUsuario);
//        }
//        servicioUsuario.eliminar(idUsuario);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}

