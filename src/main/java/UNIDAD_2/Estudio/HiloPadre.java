package UNIDAD_2.Estudio;

public class HiloPadre {
	
	public HiloPadre() {
		
	}

	public static void main(String[] args) {
		Hilo hilo = new Hilo("Hilo 1");
		hilo.start();
		Hilo hilo2 = new Hilo("Hilo 2");
		hilo2.start();
	}
}
