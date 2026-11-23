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
			System.out.println(Thread.currentThread().getName() + " espera: la bandeja está llena");
			wait(); // Bandeja llena
		}
		bandeja.add(plato);
		System.out.println(Thread.currentThread().getName() + " deja " + plato + ". Platos en la bandeja: " + bandeja.size());
		notifyAll();
	}

	public synchronized String retiroPlato() throws InterruptedException {
		while (bandeja.isEmpty()) {
			System.out.println(Thread.currentThread().getName() + " espera: la bandeja está vacía");
			wait(); // Bandeja vacía
		}
		String plato = bandeja.remove(0);
		System.out.println(Thread.currentThread().getName() + " retira " + plato + ". Platos en la bandeja: " + bandeja.size());
		notifyAll();
		return plato;
	}
}
