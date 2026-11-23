package UNIDAD_2.Boletin_4.Ej3;

public class ReintegrosHilo implements Runnable {
	private Cuenta cuenta;

	public ReintegrosHilo(Cuenta cuenta) {
		super();
		this.cuenta = cuenta;
	}

	@Override
	public void run() {
		try {
			// Empieza medio segundo después para que se alternen con los ingresos
			Thread.sleep(500);
			for (int i = 0; i < 5; i++) {
				int aleatorio = ((int) (Math.random() * 500 + 1));
				cuenta.retirarDinero(aleatorio);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
