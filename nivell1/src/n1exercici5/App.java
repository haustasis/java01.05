package n1exercici5;

import java.io.*;

/*
Exercici 5. Mostri com serialitzar un Objecte Java a un fitxer .ser i deserialícelo després.
 */
public class App {

    public static void main(String[] args) {
        Coche car1 = new Coche("maserati", "levante", 90000);

        // Serialitzar
        try {
            FileOutputStream fileOut = new FileOutputStream("coche.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(car1);
            out.close();
            fileOut.close();
            System.out.println("Object Java serialitzat a /coche.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

        // Deserialitzar
        Coche car2 = null;
        try {
            FileInputStream fileIn = new FileInputStream("coche.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            car2 = (Coche) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Object Java deserialitzat");
        System.out.println("Marca: " + car2.getMarca());
        System.out.println("Modelo: " + car2.getModelo());
        System.out.println("Precio: " + car2.getPrecio());
    }
}
