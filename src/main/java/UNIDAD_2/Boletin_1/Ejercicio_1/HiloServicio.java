package UNIDAD_2.Boletin_1.Ejercicio_1;

public class HiloServicio extends Thread{

	public HiloServicio(String name) {
		super(name);
	}

	@Override
	public void run() {
		while(true) {
			System.out.println(getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
