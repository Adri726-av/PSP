package UNIDAD_1.Ventas;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DetectaDevoluciones {
	public static void main(String[] args) {
		
	}
	
	public void generaFichero() throws IOException {
		Scanner in = null;
		try {
			int contador = 0;
			in = new Scanner(System.in); 
			double importeTotal = 0;
			PrintWriter escribo = null; 
			while (in.hasNext()) { //Lectura palabra a palabra
				String linea = in.nextLine();
				String[] partes = linea.split(";");
				int unidadesNeg = Integer.parseInt(partes[3]);
				if (unidadesNeg < 0) {
					FileWriter ficheroSalida = new FileWriter("src/main/resources/devoluciones.txt",StandardCharsets.UTF_8);
					escribo = new PrintWriter(ficheroSalida);
					int unidades = Integer.parseInt(partes[3]);
					double precio = Double.parseDouble(partes[4]);
					contador++;
					importeTotal = unidades * precio;
				}
			}
			System.out.println("Importe total devuelto: " + importeTotal);
			escribo.close();
			System.exit(contador);
		} finally {
			if (in != null) {
				in.close();
				// OjO Al cerrar el Scanner cierra también el FileReader que envuelve.
			}
		}
	}
}
