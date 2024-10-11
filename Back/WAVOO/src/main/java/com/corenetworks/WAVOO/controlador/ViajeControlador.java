package com.corenetworks.WAVOO.controlador;

import com.corenetworks.WAVOO.dto.BusquedaCompleta;
import com.corenetworks.WAVOO.dto.impl.BusquedaCompletaDTO;
import com.corenetworks.WAVOO.dto.impl.BusquedaInicialDTO;
import com.corenetworks.WAVOO.excepciones.ExcepcionNoEncontradoModelo;
import com.corenetworks.WAVOO.servicio.IServicioViaje;
import com.corenetworks.WAVOO.modelo.Viaje;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("viajes")
public class ViajeControlador {

    @Autowired
    private IServicioViaje servicioViaje;

    @Autowired
    private ModelMapper mapper;

//    @GetMapping
//    public ResponseEntity<List<Viaje>> consultarTodos() throws Exception {
//
//        List<Viaje> resultado = servicioViaje.listar();
//        return new ResponseEntity<>(resultado, HttpStatus.OK);
//    }

    @GetMapping("/{origen}/{destino}/{fInicio}/{fFin}/{pDisponible}")
    public ResponseEntity<List<BusquedaInicialDTO>> buscarViajes(@PathVariable("origen")String origen,
    @PathVariable("destino") String destino, @PathVariable("fInicio") LocalDate fechaInicio,
    @PathVariable("fFin") LocalDate fechaFinal, @PathVariable("pDisponible") Short pDisponible) throws Exception {

        List<BusquedaInicialDTO> resultado = servicioViaje.busquedaInicial(origen, destino, fechaInicio, fechaFinal, pDisponible)
                .stream().map(x -> mapper.map(x, BusquedaInicialDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @GetMapping("/{idViaje}")
    public ResponseEntity<BusquedaCompletaDTO> consultarUno(@PathVariable("idViaje") int idViaje) throws Exception {
        BusquedaCompleta busquedaCompleta = servicioViaje.busquedaCompleta(idViaje);
        if (busquedaCompleta == null) {
            throw new ExcepcionNoEncontradoModelo("ID No encontrado " + idViaje);
        }
        BusquedaCompletaDTO dtoResponse = mapper.map(busquedaCompleta, BusquedaCompletaDTO.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BusquedaCompletaDTO> insertar(@Validated @RequestBody BusquedaCompletaDTO viajeDTO) throws Exception {
        Viaje viaje = mapper.map(viajeDTO, Viaje.class);
        BusquedaCompletaDTO dtoResponse = mapper.map(servicioViaje.registrar(viaje), BusquedaCompletaDTO.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BusquedaCompletaDTO> modificar(@Validated @RequestBody BusquedaCompletaDTO viajeDTO) throws Exception {
        Viaje viaje = mapper.map(viajeDTO, Viaje.class);
        Viaje viajeExistente = servicioViaje.listarPorId(viaje.getIdViaje());
        if (viajeExistente == null) {
            throw new ExcepcionNoEncontradoModelo("ID No encontrado " + viaje.getIdViaje());
        }
        return new ResponseEntity<>(mapper.map(servicioViaje.modificar(viaje), BusquedaCompletaDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("{idViaje}")
    public ResponseEntity<Void> eliminar(@PathVariable("idViaje") int idViaje) throws Exception {
        Viaje viajeExistente = servicioViaje.listarPorId(idViaje);
        if (viajeExistente == null) {
            throw new ExcepcionNoEncontradoModelo("ID No encontrado " + idViaje);
        }
        servicioViaje.eliminar(idViaje);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
