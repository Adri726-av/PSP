package UNIDAD_2.Boletin_1.Ejercicio_1;

import UNIDAD_2.Estudio.Hilo;

public class HiloPadre {

	public HiloPadre() {
		super();
	}
	
	public static void main(String[] args) {
		HiloProceso hilo = new HiloProceso("PROCESOS");
		hilo.start();
		HiloServicio hilo2 = new HiloServicio("SERVICIOS");
		hilo2.start();
	}
}
