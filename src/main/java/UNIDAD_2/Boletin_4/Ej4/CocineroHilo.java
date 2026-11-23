package UNIDAD_2.Boletin_4.Ej4;

public class CocineroHilo implements Runnable {
	private Bandeja bandeja;

	public CocineroHilo(Bandeja bandeja) {
		super();
		this.bandeja = bandeja;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 12; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + " empieza a preparar el plato " + i);
				Thread.sleep(5000);
				bandeja.pongoPlato("plato " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " ha terminado su jornada");
	}
}
