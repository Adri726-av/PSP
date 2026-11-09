package UNIDAD_2.Boletin_1.Ejercicio_2;

public class HiloProceso implements Runnable{
	String nombre;
	

	public HiloProceso(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public void run() {
		while(true) {
			System.out.println(nombre);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
