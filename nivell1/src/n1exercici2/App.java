package n1exercici2;
/*
Exercici 2. Afegeixi a la classe del nivell anterior la funcionalitat de llistar un arbre de directoris
amb el contingut de tots els seus nivells (recursivamente) de manera que s'imprimeixin en pantalla
en ordre alfabètic dins de cada nivell, indicant a més si és un directori (D) o un fitxer (F),
i la seva última data de modificació.
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