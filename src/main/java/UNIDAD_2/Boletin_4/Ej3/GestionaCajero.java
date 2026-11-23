package UNIDAD_2.Boletin_4.Ej3;

public class GestionaCajero {
	private Cuenta cuenta;

	public GestionaCajero(int saldoActual) {
		super();
		this.cuenta = new Cuenta(saldoActual);
	}

	public void iniciar() throws InterruptedException {
		System.out.println("Saldo inicial: " + cuenta.getSaldo());
		
		IngresosHilo h1 = new IngresosHilo(cuenta);
		ReintegrosHilo h2 = new ReintegrosHilo(cuenta);

		Thread ingresos = new Thread(h1, "Hilo ingresos");
		Thread reintegros = new Thread(h2, "Hilo reintegros");

		ingresos.start();
		reintegros.start();

		ingresos.join();
		reintegros.join();

		System.out.println("Saldo final: " + cuenta.getSaldo());
	}

	public static void main(String[] args) throws InterruptedException {
		GestionaCajero cajero = new GestionaCajero(500);
		cajero.iniciar();
	}
}
