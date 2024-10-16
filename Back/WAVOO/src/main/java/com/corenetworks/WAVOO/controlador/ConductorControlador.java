//package com.corenetworks.WAVOO.controlador;
//
//import com.corenetworks.WAVOO.dto.impl.UsuarioDTO;
//import com.corenetworks.WAVOO.modelo.Usuario;
//import com.corenetworks.WAVOO.servicio.IServicioConductor;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
//@RequestMapping("conductores")
//public class ConductorControlador {
//
//
//    @Autowired
//    private IServicioConductor servicioConductor;
//
//    @Autowired
//    private ModelMapper mapper;
//
//    // Obtener un usuario por su ID
////    @GetMapping("/{idUsuario}")
////    public ResponseEntity<FormularioUsuarioDTO> consultarUno(@PathVariable("idUsuario") String idUsuario) throws Exception {
////        Usuario usuario = servicioUsuario.listarPorId(idUsuario);
////        if (usuario == null) {
////            throw new ExcepcionNoEncontradoModelo("ID No encontrado " + idUsuario);
////        }
////        FormularioUsuarioDTO dtoResponse = mapper.map(usuario, FormularioUsuarioDTO.class);
////        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
////    }
////
//    @PostMapping
//    public ResponseEntity<ConductorDTO> altaUsuario(@Validated @RequestBody ConductorDTO conductorDTO) throws Exception {
//        Conductor usuario = mapper.map(conductorDTO, Usuario.class);
//        UsuarioDTO dtoResponse = mapper.map(servicioUsuario.registrar(usuario), UsuarioDTO.class);
//        return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
//    }
//
//
//    // Modificar un usuario existente
////    @PutMapping
////    public ResponseEntity<FormularioUsuarioDTO> modificar(@Validated @RequestBody FormularioUsuarioDTO usuarioDTO) throws Exception {
////        Usuario usuario = mapper.map(usuarioDTO, Usuario.class);
////        Usuario usuarioExistente = servicioUsuario.listarPorId(usuario.getIdUsuario());
////        if (usuarioExistente == null) {
////            throw new ExcepcionNoEncontradoModelo("ID No encontrado " + usuario.getIdUsuario());
////        }
////        return new ResponseEntity<>(mapper.map(servicioUsuario.modificar(usuario), FormularioUsuarioDTO.class), HttpStatus.OK);
////    }
//
//    // Eliminar un usuario por su ID
////    @DeleteMapping("/{idUsuario}")
////    public ResponseEntity<Void> eliminar(@PathVariable("idUsuario") int idUsuario) throws Exception {
////        Usuario usuarioExistente = servicioUsuario.listarPorId(idUsuario);
////        if (usuarioExistente == null) {
////            throw new ExcepcionNoEncontradoModelo("ID No encontrado " + idUsuario);
////        }
////        servicioUsuario.eliminar(idUsuario);
////        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
////    }
//}
