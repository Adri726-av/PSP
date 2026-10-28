package UNIDAD_1.Provincias;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class generaProvincia {
	public static void main(String[] args) {
		String nombreProvincia = args[0];
		String rutaFichero = "src/main/resources/pedidos.txt";
		generaProvincia g = new generaProvincia();
		try {
			g.generaFichero(rutaFichero, nombreProvincia);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void generaFichero(String ruta, String nombreProvincia) throws IOException {
		Scanner in = null;
		try {
			int contador = 0;
			// abre el fichero
			FileReader fichero = new FileReader(ruta);
			//Se crea el flujo
			in = new Scanner(fichero);
			FileWriter ficheroSalida = new FileWriter("src/main/resources/" + nombreProvincia + ".txt", StandardCharsets.UTF_8); // Creamos una instancia con la ruta donde queremos crear el fichero
			PrintWriter escribo = new PrintWriter(ficheroSalida); // Creamos otra instancia para escribir en el fichero
			// lee el fichero
			while (in.hasNext()) { //Lectura palabra a palabra
				String linea = in.nextLine();
				if (linea.contains(nombreProvincia)) {
					escribo.println(linea);
					contador++;
				}
			}
			System.out.println(nombreProvincia + ":" + contador);
			escribo.close();
		} finally {
			if (in != null) {
				in.close();
				// OjO Al cerrar el Scanner cierra también el FileReader que envuelve.
			}
		}
	}
}	
