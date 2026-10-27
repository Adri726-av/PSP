package UNIDAD_1.Boletin_2.AnalizadorTemperaturas;

import java.io.File;
import java.io.IOException;

public class LanzadorAnalizadorTemperaturas {
	public static void main(String[] args) {
		LanzadorAnalizadorTemperaturas l = new LanzadorAnalizadorTemperaturas();
		String rutaCompila = "src/main/java/UNIDAD_1/Boletin_2/AnalizadorTemperaturas/AnalizadorTemperaturas.java";
		String rutaClass = "target/classes";
		String nombreClass = "UNIDAD_1.Boletin_2.AnalizadorTemperaturas.AnalizadorTemperaturas";
		
		try {
			l.compila(rutaCompila, rutaClass, nombreClass);
			l.ejecuta(rutaClass, nombreClass, "src/main/resources/datos.txt", "25", "src/main/resources/25.txt");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void compila(String rutaCompila, String rutaClass, String nombreClass) throws IOException, InterruptedException {
		File clase = new File(rutaClass + nombreClass.replace(".", "/"));
		
		if (!clase.exists()) {	
			ProcessBuilder pb = new ProcessBuilder("javac", "-d", rutaClass,  rutaCompila);
			Process p = pb.start();
			int exit = p.waitFor();
			
			System.out.println("Código de salida: " + exit);
		}
		else {
			System.out.println("El archivo ya está compilado");
		}
	}
	
	public void ejecuta(String rutaClass, String nombreClass, String parametro1, String parametro2, String parametro3) throws IOException, InterruptedException {
		String[] comando = {"java", "-cp", rutaClass, nombreClass, parametro1, parametro2, parametro3};
		ProcessBuilder pb = new ProcessBuilder(comando);
		Process p = pb.start();
		int exit = p.waitFor();
		System.out.println("Código de salida: " + exit);
	}
}
