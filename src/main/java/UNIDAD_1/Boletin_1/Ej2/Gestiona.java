package UNIDAD_1.Boletin_1.Ej2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Gestiona {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce una ruta");
			String ruta = sc.nextLine();
			
			mostrarInfo(ruta);
			sc.close();
			
		} catch (RutaNoValidaException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void mostrarInfo(String ruta) throws RutaNoValidaException {
		File f = new File(ruta);
		if (f.exists()) {
			throw new RutaNoValidaException("La ruta no existe");
		}
		
		System.out.println("Nombre: " + f.getName());
		System.out.println("Ruta como se ha escrito: " + f.getPath());
		System.out.println("Ruta absoluta: " + f.getAbsolutePath());
		try {
			System.out.println("Ruta canónica: " + f.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Directorio padre: " + f.getParent());
		
		if (f.isFile()) {
			System.out.println("Es un fichero");
		}
		else if (f.isDirectory()) {
			System.out.println("Es un directorio");
		}
		
		System.out.println("Permiso de lectura: " + f.canRead());
		System.out.println("Permiso de escritura: " + f.canWrite());
		System.out.println("Permiso de ejecución: " + f.canExecute());
		System.out.println("Oculto: " + f.isHidden());
		System.out.println("Tamaño en bytes: " + f.length());
		
		if (f.isDirectory()) {
			String[] elementos = f.list();
			System.out.println("Numero de elementos: " + elementos.length);
		}
		
		System.out.println("Fecha de la última modificación: " + f.lastModified());
	}
}
