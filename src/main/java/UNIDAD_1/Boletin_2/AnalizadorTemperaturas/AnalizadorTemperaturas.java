package UNIDAD_1.Boletin_2.AnalizadorTemperaturas;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class AnalizadorTemperaturas {
	public static void main(String[] args) {
		String nombreFichero = args[0];
		String valorUmbral = args[1];
		
		int valor = Integer.parseInt(valorUmbral);
		
		String nombreDestino = args[2];
		String ruta = "";
		
		AnalizadorTemperaturas a = new AnalizadorTemperaturas();
		
		try {
			a.contadorDias(nombreFichero, valor, nombreDestino);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void contadorDias(String ruta, int valor, String destino) throws IOException {
		Scanner in = null;
		int contador = 0;
		try {
			// abre el fichero
			FileReader fichero = new FileReader(ruta);
			//Se crea el flujo
			in = new Scanner(fichero);
			// lee el fichero
			while (in.hasNextLine()) { //Lectura palabra a palabra
				int num = Integer.parseInt(in.nextLine());
				if (num >= valor) {
					contador++;
				}
			}
		} finally {
			if (in != null) {
				in.close();
				// OjO Al cerrar el Scanner cierra también el FileReader que envuelve.
			}
		}
		FileWriter ficheroSalida = new FileWriter(destino, StandardCharsets.UTF_8); // Creamos una instancia con la ruta donde queremos crear el fichero
		PrintWriter escribo = new PrintWriter(ficheroSalida); // Creamos otra instancia para escribir en el fichero
		escribo.print("Cuantas veces supera el valor:  " + contador); // Escribimos lo que queremos en el fichero creado
		escribo.close();
	}
}