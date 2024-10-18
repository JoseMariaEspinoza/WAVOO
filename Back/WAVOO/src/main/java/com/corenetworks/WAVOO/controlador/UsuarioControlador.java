package com.corenetworks.WAVOO.controlador;


import com.corenetworks.WAVOO.dto.FormularioUsuario;
import com.corenetworks.WAVOO.dto.IUsuario;
import com.corenetworks.WAVOO.dto.impl.CochesDTO;
import com.corenetworks.WAVOO.dto.impl.EditarUsuarioDTO;
import com.corenetworks.WAVOO.dto.impl.FormularioUsuarioDTO;

import com.corenetworks.WAVOO.dto.impl.UsuarioDTO;
import com.corenetworks.WAVOO.excepciones.ContrasenaIncorrectaException;
import com.corenetworks.WAVOO.excepciones.ExcepcionNoEncontradoModelo;
import com.corenetworks.WAVOO.modelo.Coche;
import com.corenetworks.WAVOO.modelo.Conductor;
import com.corenetworks.WAVOO.modelo.Usuario;

import com.corenetworks.WAVOO.modelo.Viaje;
import com.corenetworks.WAVOO.servicio.IServicioConductor;
import com.corenetworks.WAVOO.servicio.IServicioUsuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("usuarios")
public class UsuarioControlador {

    @Autowired
    private IServicioUsuario servicioUsuario;
    @Autowired
    private IServicioConductor servicioConductor;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/{dni}")
    public ResponseEntity<EditarUsuarioDTO> editarPerfil(@PathVariable("dni") String dni) throws Exception {
        // Obtener los datos del formulario del usuario
        FormularioUsuario formularioUsuario = servicioUsuario.editarPerfil(dni);

        if (formularioUsuario == null) {
            throw new ExcepcionNoEncontradoModelo("DNI No encontrado");
        }

        // Crear el DTO de respuesta
        EditarUsuarioDTO dtoResponse = new EditarUsuarioDTO();
        dtoResponse.setDni(formularioUsuario.getDni());
        dtoResponse.setContrasena(formularioUsuario.getContrasena());
        dtoResponse.setDireccion(formularioUsuario.getDireccion());
        dtoResponse.setEmail(formularioUsuario.getEmail());
        dtoResponse.setFechaNacimiento(formularioUsuario.getFechaNacimiento());
        dtoResponse.setFotoUsuario(formularioUsuario.getFotoUsuario());
        dtoResponse.setGenero(formularioUsuario.getGenero());
        dtoResponse.setNombreCompleto(formularioUsuario.getNombreCompleto());
        dtoResponse.setPermisoConducir(formularioUsuario.isPermisoConducir());
        dtoResponse.setRPreguntaSeguridad(formularioUsuario.getRPreguntaSeguridad());
        dtoResponse.setTelefono(formularioUsuario.getTelefono());
        dtoResponse.setUsuario(formularioUsuario.getUsuario());

        // Verificar si el usuario tiene permiso de conducir
        if (formularioUsuario.isPermisoConducir()) {
            // Obtener la foto del carnet si tiene permiso de conducir
            dtoResponse.setFotoCarnet(formularioUsuario.getFotoCarnet());

            // Obtener la lista de coches para el conductor
            List<Coche> coches = servicioUsuario.obtenerCochesPorConductor(dni);

            // Mapear la lista de coches
            List<CochesDTO> cochesDTOList = coches.stream()
                    .map(coche -> new CochesDTO(
                            coche.getMatricula(),
                            coche.getMarca(),
                            coche.getModelo(),
                            coche.getCarroceria(),
                            coche.getAnio(),
                            coche.getNumeroPlazas(),
                            coche.getFotoCoche()
                    ))
                    .collect(Collectors.toList());

            // Asignar la lista de coches al DTO de respuesta
            dtoResponse.setCoches(cochesDTOList);
        }

        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }


    // Obtener un usuario por su ID
    @GetMapping("/login/{dni}/{contrasena}")
    public ResponseEntity<UsuarioDTO> identificacion(@PathVariable("dni") String dni, @PathVariable("contrasena") String contrasena) {

        FormularioUsuario iUsuario = servicioUsuario.identificacion(dni, contrasena);
        UsuarioDTO usuarioDTO = mapper.map(iUsuario, UsuarioDTO.class);
        System.out.println(usuarioDTO);
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);

    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> registrarUsuario(@RequestBody FormularioUsuarioDTO formularioUsuarioDTO) {

        // Crear un nuevo objeto Usuario o Conductor dependiendo de si tiene permiso de conducir
        if (formularioUsuarioDTO.getPermisoConducir()) {
            Conductor conductor = new Conductor();
            conductor.setDni(formularioUsuarioDTO.getDni());
            conductor.setNombreCompleto(formularioUsuarioDTO.getNombreCompleto());
            conductor.setDireccion(formularioUsuarioDTO.getDireccion());
            conductor.setFechaNacimiento(formularioUsuarioDTO.getFechaNacimiento());
            conductor.setEmail(formularioUsuarioDTO.getEmail());
            conductor.setUsuario(formularioUsuarioDTO.getUsuario());
            conductor.setContrasena(formularioUsuarioDTO.getContrasena());
            conductor.setTelefono(Integer.parseInt(formularioUsuarioDTO.getTelefono()));
            conductor.setGenero(formularioUsuarioDTO.getGenero().charAt(0));
            conductor.setPermisoConducir(true);
            conductor.setFotoUsuario(formularioUsuarioDTO.getFotoUsuario());
            conductor.setRPreguntaSeguridad(formularioUsuarioDTO.getRPreguntaSeguridad());
            conductor.setFotoCarnet(formularioUsuarioDTO.getFotoCarnet());

            // Guardar el conductor
            servicioUsuario.registrarConductor(conductor);

            // Guardar los coches asociados al conductor
            for (Coche cocheDTO : formularioUsuarioDTO.getCoches()) {
                Coche coche = new Coche();
                coche.setMatricula(cocheDTO.getMatricula());
                coche.setMarca(cocheDTO.getMarca());
                coche.setModelo(cocheDTO.getModelo());
                coche.setCarroceria(cocheDTO.getCarroceria());
                coche.setAnio(cocheDTO.getAnio());
                coche.setNumeroPlazas(cocheDTO.getNumeroPlazas());
                coche.setFotoCoche(cocheDTO.getFotoCoche());
                coche.setCo1(conductor);  // Asocia el coche al conductor
                servicioUsuario.registrarCoche(coche);
            }
        } else {
            Usuario usuario = new Usuario();
            usuario.setDni(formularioUsuarioDTO.getDni());
            usuario.setNombreCompleto(formularioUsuarioDTO.getNombreCompleto());
            usuario.setDireccion(formularioUsuarioDTO.getDireccion());
            usuario.setFechaNacimiento(formularioUsuarioDTO.getFechaNacimiento());
            usuario.setEmail(formularioUsuarioDTO.getEmail());
            usuario.setUsuario(formularioUsuarioDTO.getUsuario());
            usuario.setContrasena(formularioUsuarioDTO.getContrasena());
            usuario.setTelefono(Integer.parseInt(formularioUsuarioDTO.getTelefono()));
            usuario.setGenero(formularioUsuarioDTO.getGenero().charAt(0));
            usuario.setPermisoConducir(false);
            usuario.setFotoUsuario(formularioUsuarioDTO.getFotoUsuario());
            usuario.setRPreguntaSeguridad(formularioUsuarioDTO.getRPreguntaSeguridad());
            usuario.setUsuarioActivo(true);

            // Guardar el usuario
            try {
                servicioUsuario.registrar(usuario);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return ResponseEntity.ok("Usuario registrado correctamente");
    }


    @PutMapping("/actualizar/{dni}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable("dni") String dni, @RequestBody FormularioUsuarioDTO formularioUsuarioDTO) {

        // Buscar al usuario o conductor existente por su DNI
        Usuario usuarioExistente = null;
        try {
            usuarioExistente = servicioUsuario.listarPorId(dni);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Verificar si es un conductor o solo un usuario
        if (usuarioExistente instanceof Conductor) {
            Conductor conductorExistente = (Conductor) usuarioExistente;
            conductorExistente.setNombreCompleto(formularioUsuarioDTO.getNombreCompleto());
            conductorExistente.setDireccion(formularioUsuarioDTO.getDireccion());
            conductorExistente.setFechaNacimiento(formularioUsuarioDTO.getFechaNacimiento());
            conductorExistente.setEmail(formularioUsuarioDTO.getEmail());
            conductorExistente.setUsuario(formularioUsuarioDTO.getUsuario());
            conductorExistente.setContrasena(formularioUsuarioDTO.getContrasena());
            conductorExistente.setTelefono(Integer.parseInt(formularioUsuarioDTO.getTelefono()));
            conductorExistente.setGenero(formularioUsuarioDTO.getGenero().charAt(0));
            conductorExistente.setPermisoConducir(true);
            conductorExistente.setFotoUsuario(formularioUsuarioDTO.getFotoUsuario());
            conductorExistente.setRPreguntaSeguridad(formularioUsuarioDTO.getRPreguntaSeguridad());
            conductorExistente.setFotoCarnet(formularioUsuarioDTO.getFotoCarnet());

            // Actualizar los coches asociados al conductor
            for (Coche cocheDTO : formularioUsuarioDTO.getCoches()) {
                Coche cocheExistente = servicioUsuario.buscarCochePorMatricula(cocheDTO.getMatricula())
                        .orElseThrow(() -> new ExcepcionNoEncontradoModelo("Coche no encontrado"));

                cocheExistente.setMarca(cocheDTO.getMarca());
                cocheExistente.setModelo(cocheDTO.getModelo());
                cocheExistente.setCarroceria(cocheDTO.getCarroceria());
                cocheExistente.setAnio(cocheDTO.getAnio());
                cocheExistente.setNumeroPlazas(cocheDTO.getNumeroPlazas());
                cocheExistente.setFotoCoche(cocheDTO.getFotoCoche());
                cocheExistente.setCo1(conductorExistente);  // Asociar el coche al conductor actualizado

                // Actualizar el coche
                servicioUsuario.registrarCoche(cocheExistente);
            }

            // Guardar el conductor actualizado
            servicioUsuario.registrarConductor(conductorExistente);
        } else {
            // Si es solo un usuario (no conductor)
            usuarioExistente.setNombreCompleto(formularioUsuarioDTO.getNombreCompleto());
            usuarioExistente.setDireccion(formularioUsuarioDTO.getDireccion());
            usuarioExistente.setFechaNacimiento(formularioUsuarioDTO.getFechaNacimiento());
            usuarioExistente.setEmail(formularioUsuarioDTO.getEmail());
            usuarioExistente.setUsuario(formularioUsuarioDTO.getUsuario());
            usuarioExistente.setContrasena(formularioUsuarioDTO.getContrasena());
            usuarioExistente.setTelefono(Integer.parseInt(formularioUsuarioDTO.getTelefono()));
            usuarioExistente.setGenero(formularioUsuarioDTO.getGenero().charAt(0));
            usuarioExistente.setPermisoConducir(false);
            usuarioExistente.setFotoUsuario(formularioUsuarioDTO.getFotoUsuario());
            usuarioExistente.setRPreguntaSeguridad(formularioUsuarioDTO.getRPreguntaSeguridad());

            // Guardar el usuario actualizado
            try {
                servicioUsuario.modificar(usuarioExistente);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return ResponseEntity.ok("Usuario actualizado correctamente");
    }
    @PutMapping("/desactivar/{idUsuario}")
    public ResponseEntity<Void> desactivarUsuario(@PathVariable("idUsuario") String dni) throws Exception {
        Usuario usuarioExistente = servicioUsuario.listarPorId(dni);
        if (usuarioExistente == null) {
            throw new ExcepcionNoEncontradoModelo("Dni No encontrado ");
        }
        usuarioExistente.setUsuarioActivo(false);
        servicioUsuario.modificar(usuarioExistente);  // Asumiendo que tienes un método `modificar` en tu servicio
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}

