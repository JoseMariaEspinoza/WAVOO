package com.corenetworks.WAVOO.controlador;

import com.corenetworks.WAVOO.dto.BusquedaCompleta;
import com.corenetworks.WAVOO.dto.impl.BusquedaCompletaDTO;
import com.corenetworks.WAVOO.dto.impl.BusquedaInicialDTO;
import com.corenetworks.WAVOO.dto.impl.PlazaInfoDTO;
import com.corenetworks.WAVOO.dto.impl.ViajeDTO;
import com.corenetworks.WAVOO.excepciones.ExcepcionNoEncontradoModelo;
import com.corenetworks.WAVOO.servicio.IServicioCoche;
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
    private IServicioCoche servicioCoche;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/todos")
    public ResponseEntity<List<BusquedaInicialDTO>> buscarTodosLosViajes() throws Exception {
        // Obtener todos los viajes desde el servicio
        List<BusquedaInicialDTO> resultado = servicioViaje.listar()
                .stream().map(x -> mapper.map(x, BusquedaInicialDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

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
        // Obtiene el objeto BusquedaCompleta correspondiente al idViaje
        BusquedaCompleta busquedaCompleta = servicioViaje.busquedaCompleta(idViaje);

        // Verifica si el viaje existe
        if (busquedaCompleta == null) {
            throw new ExcepcionNoEncontradoModelo("ID No encontrado " + idViaje);
        }

        // Mapea el objeto BusquedaCompleta a BusquedaCompletaDTO
        BusquedaCompletaDTO dtoResponse = mapper.map(busquedaCompleta, BusquedaCompletaDTO.class);

        // Aquí asumimos que en la clase BusquedaCompleta hay un método que te devuelve la lista de plazas
        List<PlazaInfoDTO> plazasInfoDTO = busquedaCompleta.getPlazas().stream()
                .map(plaza -> mapper.map(plaza, PlazaInfoDTO.class)) // Mapea cada Plaza a PlazaInfoDTO
                .collect(Collectors.toList());

        // Asigna la lista de plazas al DTO
        dtoResponse.setPlazas(plazasInfoDTO);

        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ViajeDTO> insertar(@Validated @RequestBody ViajeDTO viajeDTO) throws Exception {
        Viaje viaje = mapper.map(viajeDTO, Viaje.class);
        viaje.setC1(servicioCoche.listarPorId(viajeDTO.getMatricula()));

        // Llamar al servicio con el DNI del conductor
        ViajeDTO dtoResponse = mapper.map(servicioViaje.darDeAltaViaje(viaje), ViajeDTO.class);

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

    @DeleteMapping("/{idViaje}")
    public ResponseEntity<Void> eliminarViaje(@PathVariable("idViaje") Integer idViaje) {
        try {
            // Llamar al servicio para eliminar el viaje
            servicioViaje.eliminarViaje(idViaje);
            // Retornar un estado 204 No Content indicando que la eliminación fue exitosa
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ExcepcionNoEncontradoModelo e) {
            // Si no se encuentra el viaje, retornar un estado 404 Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // En caso de cualquier otro error, retornar un estado 500 Internal Server Error
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
