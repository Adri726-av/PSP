package UNIDAD_2.Boletin_4.Ej1;

public class Gestiona {
	public static void main(String[] args) {
		Hilo h1 = new Hilo("a");
		Hilo h2 = new Hilo("e");
		Hilo h3 = new Hilo("i");
		Hilo h4 = new Hilo("o");
		Hilo h5 = new Hilo("u");
		
		Thread hilo1 = new Thread(h1);
		Thread hilo2 = new Thread(h2);
		Thread hilo3 = new Thread(h3);
		Thread hilo4 = new Thread(h4);
		Thread hilo5 = new Thread(h5);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
	}
}
