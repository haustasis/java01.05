package n1exercici4;

import java.io.*;
import java.util.Arrays;
import java.util.Date;

public class App {

    public static void main(String[] args) {

        // LLEGIR DIRECTORIS I GUARDAR EN UN ARCHIU
        PrintStream console = System.out;
        try {
            File directorio = new File("nivell1");
            PrintStream fileOut = new PrintStream("resultat.txt");
            System.setOut(fileOut);
            verDirectorioContenido(directorio);
        } catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }

        // LLEGIR FITXER TXT I MOSTRAR PER CONSOLA
        try {
        File file = new File("resultat0.txt");
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(file));
        String st;
        System.setOut(console);
            while ((st = br.readLine()) != null) {
                System.out.println(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void verDirectorioContenido(File directorio) {
        try {
            File[] archivos = directorio.listFiles();
            Arrays.sort(archivos);
            for (File archivo : archivos) {
                Date lastMod = new Date(archivo.lastModified());
                if (archivo.isDirectory()) {
                    System.out.println("(D) " + archivo.getCanonicalPath() + " " + lastMod);
                    verDirectorioContenido(archivo);
                } else {
                    System.out.println("(F) " + archivo.getCanonicalPath() + " " + lastMod);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}