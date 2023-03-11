package Caso2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Lectura de datos.
 * 
 * Clase que realiza la lectura de los ficheros almacenados en la carpeta 'data', son los datos con los que trabaja el programa.
 * 
 * Para el caso base, se tienen dos ficheros .dat
 *  - InversionsTest_6.dat
 *  - InversionsTest_12.dat
 * 
 * @version 0.1
 * @author pauli
 * 
 */


public class Datos {
    public static ArrayList<String> data() {
        File archivo = new File(FICHERO_DATOS);
        ArrayList<String> lineas = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(archivo);
            Scanner scanner = new Scanner(fis);
            while (scanner.hasNextLine()) {
                lineas.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] array = lineas.toArray(new String[lineas.size()]);
        System.out.println("Contenido del archivo:");
        for (String linea : array) {
            System.out.println(linea);
        }
		return lineas;
    }
}
