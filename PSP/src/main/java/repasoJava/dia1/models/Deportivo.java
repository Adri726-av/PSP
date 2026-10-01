package repasoJava.dia1.models;

import java.time.LocalDate;

import repasoJava.dia1.exceptions.CrafterException;

public class Deportivo extends Evento{
	private boolean televisado;
	private int alquiler;
	
	public Deportivo(String nombre, LocalDate fecha, int entradasVendidas, int capacidadMax, EstadoEvento estado)
			throws CrafterException {
		super(nombre, fecha, entradasVendidas, capacidadMax, estado);
		
	}
	
	public int getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(int alquiler) {
		this.alquiler = alquiler;
	}

	@Override
	double calcularCosteBase() {
		
		return 0;
	}
}
