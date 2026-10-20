package repasoJava.dia1.models;

import java.time.LocalDate;
import java.util.Objects;

import repasoJava.dia1.exceptions.CrafterException;

public abstract class Evento {
			
	private static int contador;
	private int id;
	private String nombre;
	private LocalDate fecha;
	private int entradasVendidas;
	private int capacidadMax;
	private EstadoEvento estado;
	
	public Evento(String nombre, LocalDate fecha, int entradasVendidas, int capacidadMax, EstadoEvento estado) throws CrafterException {
		super();
		if (verificaDatos(entradasVendidas, capacidadMax)) {
			contador++;
			this.id = contador;
			this.nombre = nombre;
			this.fecha = fecha;
			this.entradasVendidas = entradasVendidas;
			this.capacidadMax = capacidadMax;
			this.estado = estado;
		}
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getEntradasVendidas() {
		return entradasVendidas;
	}
	public void setEntradasVendidas(int entradasVendidas) {
		if (verificaDatos()) {
			this.entradasVendidas = entradasVendidas;
		}
		else {
			System.out.println("Los datos no son correctos");
		}
	}
	public int getCapacidadMax() {
		return capacidadMax;
	}
	public void setCapacidadMax(int capacidadMax) {
		if (verificaDatos()) {
			this.capacidadMax = capacidadMax;
		}
		else {
			System.out.println("Los datos no son correctos");
		}
	}
	
	public void setEstado(EstadoEvento estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(id));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", estado=" + estado + "]";
	}
	
	public boolean verificaDatos(int numEntradasVendidas, int capacidadMaxAsistentes) throws CrafterException {
		boolean sierto = true;
		if (!(numEntradasVendidas <= capacidadMaxAsistentes && capacidadMaxAsistentes > 0)) {
			sierto = false;
			throw new CrafterException("No es posible construir un evento con esos datos");
		}
		return sierto; 
	}
	
	public void modificaEstado(EstadoEvento nuevoEstado) throws CrafterException {
		if (estado == EstadoEvento.PENDIENTE) {
			if (nuevoEstado == EstadoEvento.PROGRAMADO && nuevoEstado == EstadoEvento.CANCELADO && nuevoEstado == EstadoEvento.FINALIZADO) {
				setEstado(nuevoEstado);
			}
			else {
				throw new CrafterException("No es posible pasar al estado: " + nuevoEstado);
			}
		}
		else if (estado == EstadoEvento.APLAZADO) {
			if (nuevoEstado == EstadoEvento.PROGRAMADO) {
				setEstado(nuevoEstado);
			}
			else {
				throw new CrafterException("No es posible pasar al estado: " + nuevoEstado);
			}
		}
	}
	
	public int getPorcentajeOcupacion() {
		int porcentaje = entradasVendidas / capacidadMax * 100;
		return porcentaje;
	}
	
	public int getPorcentajeOcupacion(int numeroEntradas) {
		int entradas = entradasVendidas + numeroEntradas;
		int porcentaje = entradas / capacidadMax * 100;
		return porcentaje;
	}
	
	abstract double calcularCosteBase();
}
