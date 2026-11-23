package UNIDAD_2.Boletin_4.Ej3;

public class IngresosHilo implements Runnable {
	private Cuenta cuenta;

	public IngresosHilo(Cuenta cuenta) {
		super();
		this.cuenta = cuenta;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			int aleatorio = ((int) (Math.random() * 500 + 1));
			cuenta.ingresarDinero(aleatorio);
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
