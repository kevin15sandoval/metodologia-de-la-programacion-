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

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public static int[][] solado(int metros, int[] tamaniosBaldosas) {
	    int[][] superficie = new int[metros][metros];
	    boolean[][] baldosasColocadas = new boolean[metros][metros];
	    int fila = 0;
	    Arrays.sort(tamaniosBaldosas);
	    for (int i = tamaniosBaldosas.length - 1; i >= 0; i--) {
	        int tamanio = tamaniosBaldosas[i];
	        while (fila < metros) {
	            boolean disponible = false;
	            for (int filas = 0; filas < metros - tamanio + 1 && !disponible; filas++) {
	                for (int columnas = 0; columnas < metros - tamanio + 1 && !disponible; columnas++) {
	                    boolean puedeColocar = true;
	                    for (int m = filas; m < filas + tamanio; m++) {
	                        for (int n = columnas; n < columnas + tamanio; n++) {
	                            if (baldosasColocadas[m][n]) {
	                                puedeColocar = false;
	                                break;
	                            }
	                        }
	                        if (!puedeColocar) {
	                            break;
	                        }
	                    }
	                    if (puedeColocar) {
	                        for (int m = filas; m < filas + tamanio; m++) {
	                            for (int n = columnas; n < columnas + tamanio; n++) {
	                                superficie[m][n] = tamanio;
	                                baldosasColocadas[m][n] = true;
	                            }
	                        }
	                        fila = filas + tamanio - 1;
	                        disponible = true;
	                    }
	                }
	            }
	            if (!disponible) {
	                break;
	            }
	        }
	    }
	    return superficie;
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
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
