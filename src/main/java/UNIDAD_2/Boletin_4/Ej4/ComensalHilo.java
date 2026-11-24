package UNIDAD_2.Boletin_4.Ej4;

public class ComensalHilo implements Runnable {
	private Bandeja bandeja;

	public ComensalHilo(Bandeja bandeja) {
		super();
		this.bandeja = bandeja;
	}

	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + " empieza a comer");
				String plato = bandeja.retiroPlato();
				Thread.sleep(3000);
				System.out.println(Thread.currentThread().getName() + " ha terminado de comer el " + plato);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " abandona el restaurante");
	}
}
