package UNIDAD_1.Provincias;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LanzadorGeneraProvincia {
	public static void main(String[] args) {
		LanzadorGeneraProvincia lp= new LanzadorGeneraProvincia();
		String rutaCompila = "src/main/resources/generaProvincia.java";
		String rutaClass = "target/classes";
		String nombreClass = "generaProvincia";
		
		String[] provincias = {"Sevilla", "Córdoba", "Huelva", "Cádiz", "Jaén", "Almería","Granada", "Málaga" };
		
		List<Integer> numeros = new ArrayList<>();
		
		try {
			lp.compila(rutaCompila, rutaClass, nombreClass);
			for (String provincia : provincias) {
				int num = lp.ejecuta(rutaClass, nombreClass, provincia);
				numeros.add(num);
			}
			
			int suma = 0;
			
			for (Integer n : numeros) {
				suma += n;
			}
			
			System.out.println("Numero total de pedidos: " + suma);
			
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
			
//			System.out.println("Código de salida de compila: " + exit);
		}
		else {
			System.out.println("El archivo ya está compilado");
		}
	}
	


	public int ejecuta(String rutaClass, String nombreClass, String par1) throws IOException, InterruptedException {
		String[] comando = {"java", "-cp", rutaClass, nombreClass, par1};
		ProcessBuilder pb = new ProcessBuilder(comando);
		Process p = pb.start();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String linea = br.readLine();
		
		int contador = 0;
		while (linea != null) {
			
			if (linea.contains(par1)) {
				System.out.println(linea);
				contador = Integer.parseInt(linea.split(":")[1]);
			}
			
			linea = br.readLine();
		}
		
		br.close();
		
		int exit = p.waitFor();
//		System.out.println("Código de salida: " + exit);
		return contador;
	}

}
