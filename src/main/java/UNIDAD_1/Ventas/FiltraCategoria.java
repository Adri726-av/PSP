package UNIDAD_1.Ventas;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FiltraCategoria {
	public static void main(String[] args) {
		String nombreFichero = args[0];
		String categoria = args[1];
		
		FiltraCategoria f = new FiltraCategoria();
		try {
			f.generaFichero(nombreFichero, categoria);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void generaFichero(String ruta, String categoria) throws IOException {
		Scanner in = null;
		try {
			int contador = 0;
			double importeNeto = 0;
			
			// abre el fichero
			FileReader fichero = new FileReader(ruta);
			//Se crea el flujo
			in = new Scanner(fichero); 
			PrintWriter escribo = null; // Creamos otra instancia para escribir en el fichero
			// lee el fichero
			while (in.hasNext()) { //Lectura palabra a palabra
				String linea = in.nextLine();
				String[] partes = linea.split(";");
				
				if (linea.contains(categoria)) {
					if (escribo == null) {
						FileWriter ficheroSalida = new FileWriter("src/main/resources/" + categoria + ".txt",StandardCharsets.UTF_8);
						escribo = new PrintWriter(ficheroSalida);
					}
					escribo.println(linea);
					contador++;
					
					int unidades = Integer.parseInt(partes[3]);
					double precio = Double.parseDouble(partes[4]);
					
					importeNeto = unidades * precio;
				}
			}
			System.out.println(categoria + " : " + contador + " : " + importeNeto);
			escribo.close();
		} finally {
			if (in != null) {
				in.close();
				// OjO Al cerrar el Scanner cierra también el FileReader que envuelve.
			}
		}
	}
}
