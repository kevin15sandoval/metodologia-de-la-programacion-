package becasDeColaboracion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Presentacion {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("------------------------------------");
        System.out.println("CASO 4: CAZADORA DE BECAS");
        System.out.println("------------------------------------\n\n");

        int numBecas = leerNumeroBecas();
        Beca[] becas = new Beca[numBecas];  // @German: creo un array de becas, de tipo Beca.

        becas = rellenarBecas(numBecas);    // @German: relleno el array de becas con los datos del fichero.

        // @German: muestro por pantalla los datos de las becas.
        System.out.println("Beca <n>: <inicio> <fin> <cantidad>\n");
        for (int i = 0; i < numBecas; i++) {
           // System.out.printf("Beca %d: %d %d %d\n", i, becas[i].getMesInicio(), becas[i].getMesFin(), becas[i].getCantidad());
        }

    }


    // @German: Leo la cantidad de becas que hay en el fichero
    public static int leerNumeroBecas() {
        int numBecas = 0;
        // @German: Abro el fichero y trato excepcion en el caso de que ocurra.
        try {
            File fichero = new File("doc/ficheroBecas.dat");
            Scanner sc = new Scanner(fichero);
            numBecas = sc.nextInt();
            sc.close();

            return numBecas;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }

        return numBecas;
    }

    public static Beca[] rellenarBecas (int numBecas){
        Beca[] becas = new Beca[numBecas];

        for (int i = 0; i < numBecas; i++) {
            becas[i] = new Beca(0, 0, 0);
        }

        // @German: Abro el fichero y trato excepcion en el caso de que ocurra.
        try {
            File fichero = new File("doc/ficheroBecas.dat");
            Scanner sc = new Scanner(fichero);
            sc.nextInt();

            for (int i = 0; i < numBecas; i++) {
                sc.nextInt();
               /* becas[i].setInicio(sc.nextInt());
                becas[i].setFin(sc.nextInt());
                becas[i].setCantidad(sc.nextInt());*/
            }
            sc.close();

            return becas;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }


        return becas;
    }
}