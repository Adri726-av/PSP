package UNIDAD_2.Boletin_4.Ej4;

import java.util.ArrayList;
import java.util.List;

public class Bandeja {
	private int capacidad;
	List<String> bandeja;
	
	public Bandeja() {
		super();
		this.capacidad = 3;
		this.bandeja = new ArrayList<String>();
	}
	
	public synchronized void pongoPlato(String plato) throws InterruptedException {
		while (bandeja.size() == capacidad) {
			wait(); // Buffer lleno (osea la lista)
		}
		bandeja.add(plato);
		notifyAll();
	}
	
	public synchronized void retiroPlato() {
		
	}
}
