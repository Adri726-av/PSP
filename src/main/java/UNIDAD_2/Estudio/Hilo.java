package UNIDAD_2.Estudio;

public class Hilo extends Thread{
	public Hilo(String name) {
		super(name);
	}
	
	public void run() {
//		for (int i = 0; i < 10; i++) {
//			System.out.println(i + " " + getName());
//			try {
//				sleep((long) (Math.random() * 1000));
//			}
//			catch (InterruptedException e) {
//			}
//		}
//		System.out.println("FIN! " + getName());
		System.out.println("Entro en el hilo " + getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
