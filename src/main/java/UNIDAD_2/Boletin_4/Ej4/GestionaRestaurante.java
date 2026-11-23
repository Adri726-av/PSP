package UNIDAD_2.Boletin_4.Ej4;

public class GestionaRestaurante {
	public static void main(String[] args) {
		Bandeja bandeja = new Bandeja();
		
		CocineroHilo h1 = new CocineroHilo(bandeja);
		ComensalHilo h2 = new ComensalHilo(bandeja);
		ComensalHilo h3 = new ComensalHilo(bandeja);
		ComensalHilo h4 = new ComensalHilo(bandeja);
		
		Thread cocinero = new Thread(h1, "Cocinero");
		Thread comensal1 = new Thread(h2, "Comensal 1");
		Thread comensal2 = new Thread(h3, "Comensal 2");
		Thread comensal3 = new Thread(h4, "Comensal 3");

		cocinero.start();
		comensal1.start();
		comensal2.start();
		comensal3.start();
	}
}
