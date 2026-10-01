package repasoJava.dia1.models;

import java.time.LocalDate;

import repasoJava.dia1.exceptions.CrafterException;

public class Concierto extends Evento{
	private String artistaPrincipal;
	private String[] artistasInvitados;
	private int numInvitados;

	public Concierto(String nombre, LocalDate fecha, int entradasVendidas, int capacidadMax, EstadoEvento estado, String artistaPrincipal) 
			throws CrafterException {
		super(nombre, fecha, entradasVendidas, capacidadMax, estado);
		this.artistaPrincipal = artistaPrincipal;
		artistasInvitados = new String[10]; // Inicializar la tabla
		numInvitados++;
	}

	@Override
	double calcularCosteBase() {
		double coste = 5000 + 2000 + 500 * numInvitados;
		return coste;
	}
}
