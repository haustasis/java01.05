package n1exercici3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Date;

public class App {

    public static void main(String[] args) {

        try {
            File directorio = new File("nivell1");
            PrintStream console = System.out;
            PrintStream fileOut = new PrintStream("resultat.txt");
            System.setOut(fileOut);
            verDirectorioContenido(directorio);
        } catch(FileNotFoundException ex) {
            ex.printStackTrace();
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