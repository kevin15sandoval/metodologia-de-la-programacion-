package Becas2;

import java.util.Arrays;
import java.util.Scanner;

public class pureba {

	/**
	 * Método principal para probar el algoritmo.
	 *
	 */
	public static void main(String[] args) {
		// Establecemos un Scanner, el cual lo utilizaremos para introducir los datos
		// necesarios desde le teclado
		Scanner leer = new Scanner(System.in);
		int metros;
		do {
		    System.out.println("¿De qué tamaño en m2 es la superficie?");
		    metros = leer.nextInt();
		    if (metros < 0) {
		        System.out.println("El número tiene que ser mayor que cero, vuelva a introducirlo por favor");
		    }
		} while (metros < 0);


		// Preguntamos al usuario la cantidad de baldosas que dispone para de esta
		// manera asignar el tamaño al array de tamaños de baldosas
		System.out.println("Introduzca el número de baldosas disponibles");
		int baldosas = leer.nextInt();
		if (baldosas < 0) {
			System.out.println("El numero tiene que ser mayor que cero, vuelvalo a introducirlo por favor");
			main(args);
		} // end if
			// Declaramos el array que utilizaremos para guardar el tamaño de las baldosas
			// disponibles
		int[] tamanios = new int[baldosas];
		// Realizamos un for para ir guardando el valor de las baldosas en el array
		for (int i = 0; i < tamanios.length; i++) {
			System.out.println("Introduzca el tamaño de la baldosa " + (i + 1));
			// Asignamos que en la posición i del array se vaya colocando el tamaño que el
			// usuario vaya designando
			tamanios[i] = leer.nextInt();
		} // end for
			// Mostramos información al usuario de lo que dispone
		System.out.print("Usted dispone de " + baldosas + " tamaños de baldosas:\n");
		for (int i = 0; i < tamanios.length; i++) {
			System.out.print(i + 1 + ") " + tamanios[i] + "m2\n ");
		}
		System.out.println();

		int[][] solucion = solado(metros, tamanios);

		imprimirMatriz(solucion);
	}

	/**
	 * Resuelve el problema de solado de una superficie cuadrada con diferentes
	 * tamaños de baldosas mediante un algoritmo voraz.
	 *
	 * @param metros           el lado de la superficie a solar en metros.
	 * @param tamaniosBaldosas los distintos tamaños de baldosas disponibles, en
	 *                         metros.
	 * @return una matriz que representa la disposición de las baldosas en la
	 *         superficie. Cada elemento de la matriz es un número que indica el
	 *         tamaño de la baldosa utilizada en esa posición, o 0 si la posición
	 *         está vacía.
	 */
	public static int[][] solado(int metros, int[] tamaniosBaldosas) {
		// creamos un array bidimensional para recrear la superficie en m2
		int[][] superficie = new int[metros][metros];
		//for (int crear = 0; crear < metros; crear++) {
			/*for (int crear2 = 0; crear2 < metros; crear2++) {
				superficie[crear][crear2] = 0;
				System.out.print(superficie[crear][crear2] + " ");
			} // end for
			System.out.println();
		} // end for
		System.out.println("\nEstas es el sulo vacio, ponte a trabajar\n");
		*/
		int fila = 0;
		// ordenamos las baldosas de mayor a menor
		Arrays.sort(tamaniosBaldosas);
		// Creamos un bucle for que recorre los tamaños de baldosas desde el más grande
		// hasta el más pequeño.
		for (int i = tamaniosBaldosas.length - 1; i >= 0; i--) {
			// creamos una variable tamaño para conocer el tamaño de la baldosa en esa
			// posicion del array
			int tamanio = tamaniosBaldosas[i];
			// creamos un bucle while para ir recorriendo las filas de la matriz desde la
			// primera a la ultima
			while (fila < metros) {
				// Creamos una e inicializamos la variable booleana "encontrada" como false, que
				// se usará para saber
				// si se encontró una posición disponible para colocar la baldosa y nos ayudara
				// a controlar los for's mas adelnate.
				boolean encontrada = false;
				// Este bucle for recorre las filas de la matriz desde la primera hasta la
				// última posible posición de una baldosa del tamaño actual. Si la baldosa no
				// cabe
				// en la última fila posible, entonces no tiene sentido buscar más allá de esa
				// fila.
				// La condición !encontrada indica que si ya se encontró una posición para
				// colocar la baldosa, no se debe seguir buscando.
				for (int filas = 0; filas < metros - tamanio + 1 && !encontrada; filas++) {
					// Este bucle for hace lo mismo que el anterior solamente que en las columnas
					// "columnas < metros - tamanio + 1" se utiliza para garantizar que se recorran
					// únicamente las columnas dentro de los límites de la matriz, teniendo en
					// cuenta
					// el tamaño de la baldosa que se está colocando si no esto provocaria un
					// desbordadmiento.
					for (int columnas = 0; columnas < metros - tamanio + 1 && !encontrada; columnas++) {
						// Esta línea comprueba si la posición actual de la matriz está disponible
						// (valor 0).
						// Si es así, significa que se puede colocar una baldosa en esa posición.
						//if (superficie[filas + tamaniosBaldosas[i]][columnas] == 0) {
							//if (superficie[filas][columnas + tamaniosBaldosas[i]] == 0) {
								//if (superficie[filas + tamaniosBaldosas[i]][columnas + tamaniosBaldosas[i]] == 0) {

									// }
									 if (superficie[filas][columnas] == 0) {
									// Creamos dos bucles for para colocar la baldosa en la posición actual de la
									// matriz, llenando los elementos
									// correspondientes con el tamaño de la baldosa.
									for (int m = filas; m < filas + tamanio; m++) {
										for (int n = columnas; n < columnas + tamanio; n++) {
											superficie[m][n] = tamanio;
										} // end for
									} // end for
										// Ahora actualizamos la última fila ocupada por la baldosa y cambian el valor
										// de encontrada a true,
										// para asi informar que se encontró una posición para colocar la baldosa.
									fila = filas + tamanio - 1;
									encontrada = true;
								} // end if
							
							//} // end if
						//} // end if
					} // end for columnas
				} // end for filas
				// si no encontramos una posición disponible para esta baldosa, se pasa
				// siguiente tamaño.
				if (!encontrada) {
					break;
				
				} // end if
			
			} // end while
		} // end for tamaño baldosa

		return superficie;
	}// end class solado
	/**
	 * Método auxiliar para imprimir una matriz en la consola.
	 *
	 * @param matriz la matriz a imprimir.
	 */
	public static void imprimirMatriz(int[][] matriz) {
		// recorremos las filas
		for (int filas = 0; filas < matriz.length; filas++) {
			// recorremos las columnas
			for (int columnas = 0; columnas < matriz[filas].length; columnas++) {
				System.out.print(matriz[filas][columnas] + " ");
			} // end for columnas
			System.out.println();
		} // end for filas
	}// end class

}
