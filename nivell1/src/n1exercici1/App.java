package n1exercici1;

import java.io.File;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        File directorio = new File("nivell1");

        String[] directorioContenido = directorio.list();

        Arrays.sort(directorioContenido);

        for(int i = 0; i < directorioContenido.length; i++) {
            System.out.println(directorioContenido[i]);
        }

    }
}
