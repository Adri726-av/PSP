package UNIDAD_2.Boletin_1.Ejercicio_2;

public class HiloServicio implements Runnable{
	String nombre;
	
	public HiloServicio(String name) {
		super();
		this.nombre = name;
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
