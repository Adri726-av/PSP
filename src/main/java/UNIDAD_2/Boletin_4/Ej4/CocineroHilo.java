package UNIDAD_2.Boletin_4.Ej4;

public class CocineroHilo implements Runnable{
	private Bandeja bandeja;
	private String nombre;

	public CocineroHilo(Bandeja bandeja, String nombre) {
		super();
		this.bandeja = bandeja;
		this.nombre = nombre;
	}

	@Override
	public void run() {
		System.out.println("Empieza hilo" + this.nombre);
		for (int i = 0; i < 12; i++) {
			try {
				Thread.currentThread().sleep(5000);
				System.out.println("Me pongo a cocinar" + this.nombre);
				bandeja.pongoPlato(nombre);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
