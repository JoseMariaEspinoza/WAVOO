package com.corenetworks.WAVOO.controlador;

import com.corenetworks.WAVOO.dto.impl.PlazasDTO;
import com.corenetworks.WAVOO.excepciones.ExcepcionNoEncontradoModelo;
import com.corenetworks.WAVOO.modelo.Plazas;
import com.corenetworks.WAVOO.servicio.IServicioPlazas;
import com.corenetworks.WAVOO.servicio.IServicioUsuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("plazas")
public class PlazasControlador {

    @Autowired
    private IServicioPlazas servicioPlazas;
    @Autowired
    private IServicioUsuario servicioUsuario;

    @Autowired
    private ModelMapper mapper;


//    @GetMapping
//    public ResponseEntity<List<PlazasDTO>> consultarTodos() throws Exception {
//        List<PlazasDTO> resultado = servicioPlazas.listar()
//                .stream()
//                .map(plaza -> {PlazasDTO plazasDTO = mapper.map(plaza, PlazasDTO.class);
//                    if (plaza.getU1() != null) {plazasDTO.setDni(plaza.getU1().getDni());}
//                    if (plaza.getV1() != null) {plazasDTO.setIdViaje(plaza.getV1().getIdViaje());}
//                    return plazasDTO;}).collect(Collectors.toList());
//        return new ResponseEntity<>(resultado, HttpStatus.OK);
//    }

//    @PutMapping
//    public ResponseEntity<PlazasDTO> reservar(@RequestBody PlazasDTO plazasDTO) throws Exception {
//        Plazas pDisponible = servicioPlazas.listarPorId(plazasDTO.getIdPlaza());
//        pDisponible.setU1(servicioUsuario.listarPorId(plazasDTO.getDni()));
//        if (pDisponible.getU1() == null) {
//            throw new ExcepcionNoEncontradoModelo("Plaza ocupada");
//        }
//        return new ResponseEntity<>(mapper.map(servicioPlazas.modificar(pDisponible), PlazasDTO.class), HttpStatus.OK);
//    }
@PutMapping
public ResponseEntity<List<PlazasDTO>> reservar(@Validated @RequestBody PlazasDTO plazasDTO) throws Exception {
    List<PlazasDTO> plazasReservadas = new ArrayList<>();

    // Recorre el array de idPlaza
    for (int i = 0; i < plazasDTO.getIdPlaza().length; i++) {
        // Busca la plaza por ID
        Plazas pDisponible = servicioPlazas.listarPorId(plazasDTO.getIdPlaza()[i]);

        // Verifica si la plaza está ocupada
        if (pDisponible.getU1() != null) {
            throw new ExcepcionNoEncontradoModelo("Plaza ocupada para el ID: " + plazasDTO.getIdPlaza()[i]);
        }

        // Asigna el usuario a la plaza
        pDisponible.setU1(servicioUsuario.listarPorId(plazasDTO.getDni()));

        // Guarda la plaza modificada
        Plazas plazaModificada = servicioPlazas.modificar(pDisponible);

        // Agrega el DTO de la plaza reservada a la lista
        PlazasDTO plazaDTO = mapper.map(plazaModificada, PlazasDTO.class);
        plazasReservadas.add(plazaDTO);
    }

    // Devuelve las plazas reservadas
    return new ResponseEntity<>(plazasReservadas, HttpStatus.OK);
}
}

