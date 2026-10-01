package UNIDAD_1.Boletin_1.Ej1;

import java.io.File;
import java.util.Scanner;

public class Gestiona {
	public static void main(String[] args) throws RutaNoValidaException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce la ruta: ");
		String ruta = sc.nextLine();
		File directorio = new File(ruta);
		
		if (directorio.isDirectory()) {
			throw new RutaNoValidaException("La ruta indicada no es un directorio");
		}
		if (directorio.exists()) {
			throw new RutaNoValidaException("La ruta indicada no existe");
		}
		
		int ficheros = 0;
		int directorios = 0;
		
		for (File f : directorio.listFiles()) {
			System.out.println(f.getName());
			if(f.isDirectory()) {
				System.out.println("Es un directorio");
				directorios++;
			}
			else {
				System.out.println("Es un fichero");
				ficheros++;
			}
		}
		System.out.println("Hay un total de " + ficheros + " ficheros");
		System.out.println("Y un total de " + directorios + " directorios");
	}
}
