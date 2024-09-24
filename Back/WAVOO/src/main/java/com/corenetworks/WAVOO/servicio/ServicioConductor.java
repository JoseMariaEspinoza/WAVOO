package com.corenetworks.WAVOO.servicio;

import com.corenetworks.WAVOO.modelo.Conductor;
import com.corenetworks.WAVOO.repositorio.IRepositorioConductor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
public class ServicioConductor implements IServicioConductor{
    @Autowired
    private IRepositorioConductor repoConductor;

    @Override
    public Conductor consultarUno(String dni) {
        return repoConductor.findById(dni).orElse(null);
    }

    @Override
    public Conductor crearConductor(Conductor c) {
        return repoConductor.save(c);
    }

    @Override
    public Conductor modificarConductor(Conductor c) {
        return repoConductor.save(c);
    }

    @Override
    public void suspenderCuenta(String dni) {
        repoConductor.deleteById(dni);
    }
}
