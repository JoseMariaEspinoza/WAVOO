package com.corenetworks.WAVOO.excepciones;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExcepcionNoEncontradoModelo extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExcepcionNoEncontradoModelo(String mensaje) {
		// TODO Auto-generated constructor stub
		super(mensaje);
	}

}
