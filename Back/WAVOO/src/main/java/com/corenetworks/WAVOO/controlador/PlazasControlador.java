package com.corenetworks.WAVOO.controlador;

import com.corenetworks.WAVOO.dto.impl.PlazasDTO;
import com.corenetworks.WAVOO.excepciones.ExcepcionNoEncontradoModelo;
import com.corenetworks.WAVOO.modelo.Plazas;
import com.corenetworks.WAVOO.modelo.Viaje;
import com.corenetworks.WAVOO.servicio.IServicioPlazas;
import com.corenetworks.WAVOO.servicio.IServicioUsuario;
import com.corenetworks.WAVOO.servicio.IServicioViaje;
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
    private IServicioViaje servicioViaje;

    @Autowired
    private ModelMapper mapper;

@PutMapping
public ResponseEntity<List<PlazasDTO>> reservar(@Validated @RequestBody PlazasDTO plazasDTO) throws Exception {
    List<PlazasDTO> plazasReservadas = new ArrayList<>();

    // Obtiene el viaje asociado al idViaje del PlazasDTO
    Viaje viaje = servicioViaje.listarPorId(plazasDTO.getIdViaje());

    // Recorre el array de idPlaza
    for (Integer elemento : plazasDTO.getIdPlaza()) {
        // Busca la plaza por ID
        Plazas pDisponible = servicioPlazas.listarPorId(elemento);

        // Verifica si la plaza está ocupada
        if (pDisponible.getU1() != null) {
            throw new ExcepcionNoEncontradoModelo("Plaza ocupada para el ID: " + elemento);
        }

        // Asigna el usuario a la plaza
        pDisponible.setU1(servicioUsuario.listarPorId(plazasDTO.getDni()));

        // Guarda la plaza modificada
        Plazas plazaModificada = servicioPlazas.modificar(pDisponible);

        // Agrega el DTO de la plaza reservada a la lista
        PlazasDTO plazaDTO = mapper.map(plazaModificada, PlazasDTO.class);
        plazasReservadas.add(plazaDTO);
    }

    // Actualiza el número de plazas disponibles
    long plazasSinAsignar = viaje.getPlazas().stream()
            .filter(plaza -> plaza.getU1() == null)
            .count();
    viaje.setPlazasDisponibles((short) plazasSinAsignar);

    // Guarda el viaje actualizado
    servicioViaje.modificar(viaje);

    // Devuelve las plazas reservadas
    return new ResponseEntity<>(plazasReservadas, HttpStatus.OK);
}
    @PutMapping("/cancelarReserva")
    public ResponseEntity<List<PlazasDTO>> cancelarReserva(@Validated @RequestBody PlazasDTO plazasDTO) throws Exception {
        List<PlazasDTO> plazasCanceladas = new ArrayList<>();

        // Obtiene el viaje asociado al idViaje del PlazasDTO
        Viaje viaje = servicioViaje.listarPorId(plazasDTO.getIdViaje());

        // Recorre el array de idPlaza
        for (Integer elemento : plazasDTO.getIdPlaza()) {
            // Busca la plaza por ID
            Plazas pReservada = servicioPlazas.listarPorId(elemento);

            // Verifica si la plaza tiene un usuario asignado
            if (pReservada.getU1() == null || !pReservada.getU1().getDni().equals(plazasDTO.getDni())) {
                throw new ExcepcionNoEncontradoModelo("No se encontró una reserva activa para el ID de plaza: " + elemento);
            }

            // Libera la plaza, es decir, elimina la asignación del usuario
            pReservada.setU1(null);

            // Guarda la plaza modificada
            Plazas plazaModificada = servicioPlazas.modificar(pReservada);

            // Agrega el DTO de la plaza cancelada a la lista
            PlazasDTO plazaDTO = mapper.map(plazaModificada, PlazasDTO.class);
            plazasCanceladas.add(plazaDTO);
        }

        // Actualiza el número de plazas disponibles
        long plazasSinAsignar = viaje.getPlazas().stream()
                .filter(plaza -> plaza.getU1() == null)
                .count();
        viaje.setPlazasDisponibles((short) plazasSinAsignar);

        // Guarda el viaje actualizado
        servicioViaje.modificar(viaje);

        // Devuelve las plazas canceladas
        return new ResponseEntity<>(plazasCanceladas, HttpStatus.OK);
    }

}

