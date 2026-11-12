package UNIDAD_2.Boletin_1.Ejercicio_5;

public class GestionaMascotas {
	public static void main(String[] args) {
		Mascota mascota = new Mascota("Lulú");

        for (int i = 0; i < 100; i++) {

            Thread hilo = new Thread(mascota);
            // Los hilos estan modificando la variable al mismo tiempo
            hilo.start();
        }
        System.out.println(mascota.getContadorVecesComido());
	}
}