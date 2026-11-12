package UNIDAD_2.Boletin_1.Ejercicio_4;

public class GestionaMascotas {
	public static void main(String[] args) {
		Mascota mascota = new Mascota("Lulú");

        for (int i = 0; i < 5; i++) {

            Thread hilo = new Thread(mascota);

            hilo.start();
        }
        System.out.println(mascota.getContadorVecesComido());
	}
}
