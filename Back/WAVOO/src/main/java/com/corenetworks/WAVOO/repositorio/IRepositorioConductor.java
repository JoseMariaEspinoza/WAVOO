package com.corenetworks.WAVOO.repositorio;

import com.corenetworks.WAVOO.modelo.Conductor;
import com.corenetworks.WAVOO.modelo.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRepositorioConductor extends JpaRepository<Conductor,String> {
}
