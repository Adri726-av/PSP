package UNIDAD_2.Boletin_1.Ejercicio_5;

public class Mascota implements Runnable{
	private String nombre;
	private int contadorVecesComido;
	public Mascota(String nombre) {
		super();
		this.nombre = nombre;
		this.contadorVecesComido = 0;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getContadorVecesComido() {
		return contadorVecesComido;
	}

	public void setContadorVecesComido(int contadorVecesComido) {
		this.contadorVecesComido = contadorVecesComido;
	}

	private void comer() {
		System.out.println("La mascota con nombre " + nombre + " ha comenzado a comer: " + this.contadorVecesComido);
		try {
			Thread.sleep(contadorVecesComido * 1000);
			this.contadorVecesComido++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("La mascota con nombre " + nombre + " ha terminado de comer: " + this.contadorVecesComido);
	}

	@Override
	public void run() {
		comer();
	}
}
