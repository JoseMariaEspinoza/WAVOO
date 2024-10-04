package com.corenetworks.WAVOO.servicio.impl;

import com.corenetworks.WAVOO.modelo.Conductor;
import com.corenetworks.WAVOO.repositorio.IRepositorioConductor;
import com.corenetworks.WAVOO.servicio.IServicioConductor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
public class ServicioConductor implements IServicioConductor {
    @Autowired
    private IRepositorioConductor repoConductor;


}
