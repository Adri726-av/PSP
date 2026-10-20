package Unidad_1.CrearFicheros;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Practica {
	
	private static final Logger logger = LogManager.getLogger(Practica.class);
	
	public static void main(String[] args) {
		String ruta = "C:\\Users\\usuario1234\\Documents";
		File directorio = new File(ruta);
		//Referencio a un fichero dentro del directorio
		File fichero = new File(directorio,"fichero.txt");
		try {
			boolean creado = fichero.createNewFile(); // Aqui si creo el fichero
		}catch (IOException e) {
			logger.error("Error al crear fichero:" + e.getMessage());
		}
	}
}