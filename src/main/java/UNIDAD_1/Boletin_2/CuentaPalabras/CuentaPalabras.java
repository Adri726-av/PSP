package UNIDAD_1.Boletin_2.CuentaPalabras;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CuentaPalabras {
	public static void main(String[] args) {
		String ruta = args[0];
		String palabra = args[1];
		CuentaPalabras cp = new CuentaPalabras();
		try {
			int contador = cp.contadorPalabras(ruta, palabra);
			System.out.println("Servicio esta en el archivo " + contador + " veces");
		} catch (FileNotFoundException e) {
			System.out.println("La exsepsion ha ocurrido manin");
		}
	}
	
	public int contadorPalabras(String ruta, String palabra) throws FileNotFoundException {
		Scanner in = null;
		int contador = 0;
		try {
			// abre el fichero
			FileReader fichero = new FileReader(ruta);
			//Se crea el flujo
			in = new Scanner(fichero);
			// lee el fichero
			while (in.hasNext()) { //Lectura palabra a palabra
				String p = in.next();
				if (p.equals(palabra)) {
					contador++;
				}
			}
		} finally {
			if (in != null) {
				in.close();
				// OjO Al cerrar el Scanner cierra también el FileReader que envuelve.
			}
		}
		return contador;
	}

}
