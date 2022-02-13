package n1exercici2;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class App {

    public static void main(String[] args) {

        File directorio = new File("nivell1");
        verDirectorioContenido(directorio);
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