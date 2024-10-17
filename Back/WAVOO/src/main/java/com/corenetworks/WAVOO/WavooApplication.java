package com.corenetworks.WAVOO;

import com.corenetworks.WAVOO.servicio.IServicioViaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
