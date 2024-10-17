package com.corenetworks.WAVOO.controlador;

import com.corenetworks.WAVOO.dto.impl.CochesDTO;
import com.corenetworks.WAVOO.modelo.Coche;
import com.corenetworks.WAVOO.servicio.IServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("coches")
public class CocheControlador {
    @Autowired
    private IServicioUsuario servicioUsuario;

    @GetMapping("/1/{dni}")
    public ResponseEntity<List<CochesDTO>> obtenerCochesPorConductor(@PathVariable String dni) {
        // Obtener la lista de coches para el conductor específico
        List<Coche> coches = servicioUsuario.obtenerCochesPorConductor(dni);

        if (coches == null || coches.isEmpty()) {
            return ResponseEntity.notFound().build();  // Devuelve un 404 si no hay coches
        }

        // Mapear cada coche a CochesDTO
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

        // Retornar la lista de CochesDTO
        return ResponseEntity.ok(cochesDTOList);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<List<String>> obtenerMatriculasConductor(@PathVariable String dni) {
        List<Coche> coches = servicioUsuario.obtenerCochesPorConductor(dni);
        List<String> matriculas = coches.stream()
                .map(Coche::getMatricula)  // Extrae solo la matrícula de cada coche
                .collect(Collectors.toList());

        return ResponseEntity.ok(matriculas);
    }
    
}
