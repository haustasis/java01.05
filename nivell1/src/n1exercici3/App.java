package n1exercici3;
/*
Exercici 3. Executi l'exercici anterior guardant a un fitxer txt el resultat.
 */
import java.io.File;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        File directorio = new File("nivell1");

        String[] directorioContenido = directorio.list();

        Arrays.sort(directorioContenido);

        for(int i = 0; i < directorioContenido.length; i++) {
            System.out.println(directorioContenido[i]);

            File directorioArchivos = new File(directorio.getAbsolutePath(), directorioContenido[i]);

            if (directorioArchivos.isDirectory()) {
                String[] subDirectorio = directorioArchivos.list();
                Arrays.sort(subDirectorio);

                for(int j = 0; j < subDirectorio.length; j++) {
                    System.out.println(subDirectorio[j]);
                }
            }
        }

    }
}