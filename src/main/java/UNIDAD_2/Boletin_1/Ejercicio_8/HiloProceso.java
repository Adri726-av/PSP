package UNIDAD_2.Boletin_1.Ejercicio_8;

public class HiloProceso extends Thread{

	public HiloProceso(String name) {
		super(name);
	}

	@Override
	public void run() {
		while(Thread.currentThread().isInterrupted()) {
			System.out.println(getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
