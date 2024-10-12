package com.corenetworks.WAVOO;

import com.corenetworks.WAVOO.dto.BusquedaInicial;
import com.corenetworks.WAVOO.dto.impl.BusquedaCompletaDTO;
import com.corenetworks.WAVOO.modelo.*;
import com.corenetworks.WAVOO.servicio.IServicioCoche;
import com.corenetworks.WAVOO.servicio.IServicioViaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WavooApplication implements CommandLineRunner {
	@Autowired
	private IServicioViaje servicioViaje;

	public static void main(String[] args) {
		SpringApplication.run(WavooApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
