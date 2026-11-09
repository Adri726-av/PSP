package UNIDAD_2.Boletin_1.Ejercicio_4;

public class Mascota implements Runnable{
	private String nombre;
	private int contadorVecesComido;
	public Mascota(String nombre) {
		super();
		this.nombre = nombre;
		this.contadorVecesComido = 0;
	}
	
	private void comer() {
		this.contadorVecesComido++;
		
	}
}
