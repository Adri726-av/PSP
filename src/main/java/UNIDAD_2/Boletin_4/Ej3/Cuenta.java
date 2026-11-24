package UNIDAD_2.Boletin_4.Ej3;

public class Cuenta {
	private int saldo;

	public Cuenta(int saldo) {
		super();
		this.saldo = saldo;
	}

	public synchronized void ingresarDinero(int cantidad) {
		saldo = saldo + cantidad;
		System.out.println(Thread.currentThread().getName() + " ingresa " + cantidad + " euros. Saldo actual: " + saldo);
	}

	public synchronized void retirarDinero(int cantidad) {
		if (cantidad > saldo) {
			System.out.println(Thread.currentThread().getName() + " intenta retirar " + cantidad + " euros pero no hay saldo suficiente. Saldo actual: " + saldo);
		}
		saldo = saldo - cantidad;
		System.out.println(Thread.currentThread().getName() + " retira " + cantidad + " euros. Saldo actual: " + saldo);
	}

	public synchronized int getSaldo() {
		return this.saldo;
	}
}
