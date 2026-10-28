package UNIDAD_1.Ventas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorVentas {

    public static void main(String[] args) {

        GestorVentas g = new GestorVentas();

        String rutaClass = "target/classes";
        String rutaFiltra = "src/main/resources/FiltraCategoria.java";
        String rutaDevuelve = "src/main/resources/DetectaDevoluciones.java";

        try {
            g.compila(rutaFiltra, rutaClass, "FiltraCategoria");
            g.compila(rutaDevuelve, rutaClass, "DetectaDevoluciones");

            Scanner teclado = new Scanner(System.in);

            System.out.println("Introduce el nombre del fichero:");
            String nombreFichero = teclado.nextLine();

            System.out.println("Introduce las categorías separadas por comas:");
            String texto = teclado.nextLine();

            String[] categorias = texto.split(",");

            g.ejecuta(rutaClass, nombreFichero, categorias);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void compila(String rutaCompila, String rutaClass,
            String nombreClass) throws IOException, InterruptedException {

        File clase = new File(
            rutaClass + "/" + nombreClass.replace(".", "/") + ".class"
        );

        if (!clase.exists()) {

            ProcessBuilder pb = new ProcessBuilder(
                "javac", "-encoding", "UTF-8",
                "-d", rutaClass, rutaCompila
            );

            Process p = pb.start();
            int exit = p.waitFor();

            if (exit != 0) {
                throw new IOException(
                    "Error al compilar " + nombreClass
                );
            }

        } else {
            System.out.println(nombreClass + " ya está compilado");
        }
    }

    public void ejecuta(String rutaClass, String nombreFichero,
            String[] categorias)
            throws IOException, InterruptedException {

        List<Process> procesos = new ArrayList<>();
        List<String> nombres = new ArrayList<>();

        // PRIMERO: lanzar todos los procesos de categorías

        for (String c : categorias) {

            String categoria = c.trim();

            String[] comando = {
                "java", "-cp", rutaClass,
                "FiltraCategoria", nombreFichero, categoria
            };

            ProcessBuilder pb = new ProcessBuilder(comando);
            Process p = pb.start();

            procesos.add(p);
            nombres.add(categoria);
        }

        // SEGUNDO: lanzar el proceso de devoluciones

        String[] comandoDev = {
            "java", "-cp", rutaClass, "DetectaDevoluciones"
        };

        ProcessBuilder pbDev = new ProcessBuilder(comandoDev);
        Process procesoDev = pbDev.start();

        // TERCERO: enviar el fichero al proceso de devoluciones

        int totalVentas = 0;

        try (
            BufferedReader brFichero = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(nombreFichero),
                    StandardCharsets.UTF_8
                )
            );

            BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                    procesoDev.getOutputStream(),
                    StandardCharsets.UTF_8
                )
            )
        ) {
            String linea;

            while ((linea = brFichero.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
                totalVentas++;
            }
        }

        // CUARTO: recoger los resultados de las categorías

        int totalLineas = 0;
        double importeTotal = 0;

        System.out.println("\n===== RESUMEN POR CATEGORÍA =====");

        for (int i = 0; i < procesos.size(); i++) {

            Process p = procesos.get(i);
            String categoria = nombres.get(i);

            BufferedReader br = new BufferedReader(
                new InputStreamReader(
                    p.getInputStream(),
                    StandardCharsets.UTF_8
                )
            );

            String resultado = br.readLine();
            br.close();

            int exit = p.waitFor();

            if (exit == 2) {

                System.out.println(categoria
                    + " : sin ventas (no se genera fichero)");

            } else if (exit == 0 && resultado != null) {

                String[] partes = resultado.split(":");

                int lineas = Integer.parseInt(partes[1].trim());
                double importe = Double.parseDouble(partes[2].trim());

                System.out.printf("%s : %d líneas | %.2f €%n",
                    categoria, lineas, importe);

                totalLineas += lineas;
                importeTotal += importe;

            } else {
                System.out.println("Error al procesar " + categoria);
            }
        }

        System.out.println("---------------------------------");
        System.out.println("Nº total de líneas filtradas : "
            + totalLineas);

        System.out.printf("Importe neto total : %.2f €%n",
            importeTotal);

        // QUINTO: recoger el resultado de las devoluciones

        BufferedReader brDev = new BufferedReader(
            new InputStreamReader(
                procesoDev.getInputStream(),
                StandardCharsets.UTF_8
            )
        );

        String resultadoDev = brDev.readLine();
        brDev.close();

        int numeroDevoluciones = procesoDev.waitFor();

        double importeDevuelto = 0;

        if (resultadoDev != null) {
            importeDevuelto = Double.parseDouble(resultadoDev.trim());
        }

        System.out.println("\n===== DEVOLUCIONES =====");

        System.out.println("Nº de devoluciones : "
            + numeroDevoluciones + " de " + totalVentas + " líneas");

        System.out.printf("Importe devuelto : %.2f €%n",
            Math.abs(importeDevuelto));

        double porcentaje = 0;

        if (totalVentas > 0) {
            porcentaje = numeroDevoluciones * 100.0 / totalVentas;
        }

        System.out.printf(
            "%% de líneas que son devolución: %.2f %%%n",
            porcentaje
        );
    }
}

