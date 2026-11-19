package UNIDAD_2.Boletin_1.Ejercicio_8;

import java.util.Scanner;

public class HiloPadre {

	public HiloPadre() {
		super();
	}
	
	public static void main(String[] args) {
		HiloProceso hilo = new HiloProceso("PROCESOS");
		HiloServicio hilo2 = new HiloServicio("SERVICIOS");
		hilo.start();
		hilo2.start();
//		System.out.println("Introduce enter para parar los hilos");
//		Scanner scanner = new Scanner(System.in);
//		scanner.nextLine();	// El hilo principal espera a recibir enter
//		HiloProceso.interrupted();
//		HiloServicio.interrupted();
	}
}
