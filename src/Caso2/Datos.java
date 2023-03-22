package Caso2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
    public static int[] dataEntry() {
    	// Fichero de entrada
    	File file = new File(Interfaz.FICHERO_DATOS);
    	// Scanner de datos
    	Scanner sc = null;
    	
    	try {
    		sc = new Scanner(file);
    	} catch (FileNotFoundException e) {
    		System.out.println("Revise el nombre del fichero en Interfaz.java");
    		e.printStackTrace();
    	}
    	// Leemos el primer renglon y declaramos el tamaño del array que queremos.
    	int size = sc.nextInt();
    	// Creamos el array con el tamaño detectado
    	int[] arrayDatos = new int[size];
    	// Rellenamos el array
    	for	( int i = 0; i < size; i++ ) {
    		arrayDatos[i] = sc.nextInt(); 
    	}
    	sc.close();
    	// System.out.println(Arrays.toString(arrayDatos)); // Imprimimos los datos leídos
    	return arrayDatos;
    }
}
