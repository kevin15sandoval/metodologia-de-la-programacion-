package SoladoDeBaldosas;

import java.util.Arrays;

public class Dominio {
	/**
	 * Resuelve el problema de solado de una superficie cuadrada con diferentes
	 * tamaños de baldosas mediante un algoritmo voraz.
	 *
	 * @param metros           el lado de la superficie a solar en metros.
	 * @param tamaniosBaldosas los distintos tamaños de baldosas disponibles, en
	 *                         metros.
	 * @return una matriz que representa la disposicion de las baldosas en la
	 *         superficie. Cada elemento de la matriz es un numero que indica el
	 *         tamaño de la baldosa utilizada en esa posicion, o 0 si la posicion
	 *         esta vacia.
	 */
	public static int[][] solado(int metros, int[] tamaniosBaldosas) {
		// creamos un array bidimensional para recrear la superficie en m2
		int[][] superficie = new int[metros][metros];		
		int fila = 0;
		// ordenamos las baldosas de mayor a menor
		Arrays.sort(tamaniosBaldosas);
		// Creamos un bucle for que recorre los tamaños de baldosas desde el mas grande al mas pequeño
		for (int i = tamaniosBaldosas.length - 1; i >= 0; i--) {
			// var. tamaño para conocer el tamaño de la baldosa en esa posicion del array
			int tamanio = tamaniosBaldosas[i];
			// Bucle para ir recorriendo las filas de la matriz
			while (fila < metros) {
				// Creamos una variable booleana "disponible" como false,se usa para saber
				// si la posicion actual esta disponible para colocar la baldosa
				boolean disponible = false;
				// Este bucle recorre las filas de la matriz con el size de la baldosa actual.
				// 
				// La condicion !disponible indica que si ya se encontro una posicion para
				// colocar la baldosa, no se debe seguir buscando.
				for (int filas = 0; filas < metros - tamanio + 1 && !disponible; filas++) {
					// Este bucle for hace lo mismo que el anterior solamente que en las columnas
					// "columnas < metros - tamanio + 1" se utiliza para garantizar que se recorran
					// unicamente las columnas dentro de los limites de la matriz, teniendo en
					// cuenta el tamaño de la baldosa que se esta colocando, si no, esto provocaria un
					// desbordadmiento del array de las baldosas.
					for (int columnas = 0; columnas < metros - tamanio + 1 && !disponible; columnas++) {
						// Comprueba si la posicion actual de la matriz esta disponible ->(valor 0).
						// Si es asi, significa que se puede colocar una baldosa en esa posicion.
						
///////////////////////////////////////////////////////////////////////////////////////////////////////						
						//if (superficie[filas + tamaniosBaldosas[i]][columnas] == 0) {
							//if (superficie[filas][columnas + tamaniosBaldosas[i]] == 0) {
								//if (superficie[filas + tamaniosBaldosas[i]][columnas + tamaniosBaldosas[i]] == 0) {

									// }
///////////////////////////////////////////////////////////////////////////////////////////////////////						
									 if (superficie[filas][columnas] == 0) {
										// Creamos dos bucles for para colocar la baldosa en la posicion actual de la
										// matriz, llenando los elementos correspondientes con el tamaño de la baldosa.
										for (int m = filas; m < filas + tamanio; m++) {
											for (int n = columnas; n < columnas + tamanio; n++) {
												superficie[m][n] = tamanio;
											} // end for
										} // end for
										// Ahora actualizamos la ultima fila ocupada por la baldosa y cambian el valor de disponible a true,
										// para asi informar que se encontra una posicion para colocar la baldosa.
										fila = filas + tamanio - 1;
										disponible = true;
									 } // end if
///////////////////////////////////////////////////////////////////////////////////////////////////////							
							//} // end if
						//} // end if
///////////////////////////////////////////////////////////////////////////////////////////////////////									 
					} // end for columnas
				} // end for filas
				// si no encontramos una posicion disponible para esta baldosa, se pasa siguiente tamaño.
				if (!disponible) { break; } // end if			
			} // end while
		} // end for tama�o baldosa
		return superficie;
	}// end class solado
	/**
	 * Metodo auxiliar para imprimir una matriz en la consola.
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
