package SoladoDeBaldosas;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Solado eco.
 * Necesitamos solar una superficie cuadrada de n metros de lado.
 * A tal efecto,contratamos a los hermanos Scott,unos instaladores reformistas con amplia experiencia,para realizar el trabajo.
 * Para el solado podemos elegir diferentes baldosas cuadradas de s0,s1,s2,...,sn metros de lado. <br>
 * Gracias a sus contactos profesionales, los hermanos Scott pueden conseguir las baldosas al mismo precio por baldosa independientemente del tamano. 
 * Ademas, pueden conseguir la cantidad necesaria de baldosas de cualquier tamano. Para reducir costes, pretendemos utilizar tan pocas baldosas como sea posible 
 * y por razones esteticas queremos usar baldosas enteras (aunque se mezclen tamaños).
 * @author paulino
 * @version 0.1
 *
 */
public class Presentacion {
	
/* *****************************
 * 
 * ##~~~#~~####~~######~##~~##
 * ###~##~##~~##~~~##~~~###~##
 * ##~#~#~######~~~##~~~##~###
 * ##~~~#~##~~##~~~##~~~##~~##
 * ##~~~#~##~~##~######~##~~##
 *  
 ********************************
 */
	public static void main(String[] args) {	
		menuPrincipal();		
	}
	/**
	 * menuPrincipal del programa
	 */
	public static void menuPrincipal() {
		try (
			// Establecemos un Scanner, el cual lo utilizaremos para introducir los datos
			// necesarios desde el teclado
			Scanner leer = new Scanner(System.in)) {
			int metros;
			try {
				do {			
					System.out.println("¿De que tamanio en m2 es la superficie?");			
					metros = leer.nextInt();
					if ( metros < 0) {
						MiException.exNumNegativo();
						System.exit(1);
					}
				} while (metros < 0);
				
				// Preguntamos al usuario la cantidad de baldosas que dispone para que de esta
				// manera asignar el tamaño al array de tamaños de baldosas
				System.out.println("Introduzca el numero de baldosas disponibles");
				int baldosas = leer.nextInt();
				if (baldosas < 0) {					
					MiException.exNumNegativo();
					System.exit(1);
				} // end if
					// Declaramos el array que utilizaremos para guardar el tamaño de las baldosas disponibles
				int[] tamanios = new int[baldosas];
				// Realizamos un for para ir guardando el valor de las baldosas en el array
				for (int i = 0; i < tamanios.length; i++) {
					System.out.println("Introduzca el tamanio de la baldosa " + (i + 1));
					// Asignamos que en la posicion i del array se vaya colocando el tamaño que el usuario vaya designando
					tamanios[i] = leer.nextInt();
					if (tamanios[i] <= 0) {
						MiException.exNumNegativo();
						System.exit(1);
					}
				} // end for
					// Mostramos informacion al usuario de lo que dispone
				System.out.print("Usted dispone de " + baldosas + " tamanios de baldosas:\n");
				for (int i = 0; i < tamanios.length; i++) {
					System.out.print(i + 1 + ") " + tamanios[i] + "m2\n ");
				}
				System.out.println();

				int[][] solucion = Dominio.solado(metros, tamanios);

				Dominio.imprimirMatriz(solucion);
			} catch (InputMismatchException e) {
				MiException.exSrtring();
			}
		}	
	}
}

/* **********************************************************************
 * 
 * #####~##~~##~~####~~#####~#####~~######~######~~####~~##~~##~~####~
 * ##~~~~~####~~##~~##~##~~~~##~~##~~~##~~~~~##~~~##~~##~###~##~##~~~~
 * ####~~~~##~~~##~~~~~####~~#####~~~~##~~~~~##~~~##~~##~##~###~~####~
 * ##~~~~~####~~##~~##~##~~~~##~~~~~~~##~~~~~##~~~##~~##~##~~##~~~~~##
 * #####~##~~##~~####~~#####~##~~~~~~~##~~~######~~####~~##~~##~~####~
 * 
 * **********************************************************************
 */

class MiException extends Exception {
	/**
	 * Implementacion de interfaz serializable. Las clases que implementan este interfaz son susceptibles de ser serializables (guardadas en disco)
	 * Los atributos del objeto se convierten en cadenas de bytes y se guardan en el disco. Para leer un objeto, se leen las cadenas de bytes y se reconstruye
	 * el objeto a partir de ellos.
	 * @see Source: https://howtodoinjava.com/java/serialization/serialversionuid/
	 */
	private static final long serialVersionUID = 1L;	
	/**
	 * Mensaje de control de numeros negativos
	 */
	static void exNumNegativo() {
		System.out.print("""
				===================================================== \n
				\t\t WARNING!!! \n 
				Medida invalida. \n
				El numero introducido es cero o negativo. \n
				Por favor, reinicie la ejecucion del programa
				===================================================== \n
				""");
	}
	/**
	 * Mensaje de control de String introducido 
	 */
	public static void exSrtring() {
		System.out.print("""
				===================================================== \n
				\t\t WARNING!!! \n 
				Medida invalida. \n
				Ha introducido un String, debe introducir solo numeros. \n
				===================================================== \n
				""");		
	}
}
