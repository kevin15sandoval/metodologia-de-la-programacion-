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
		//declaramos las variables que vamos a utulizar
		int ultimaBaldosa =0, ultimaFila=0, ultimaColumna=0, primeraFila =0, primeraColumna=0;
	    int[][] superficie = new int[metros][metros]; // Creamos una matriz para represantar la superficie del suelo
	    boolean[][] baldosasColocadas = new boolean[metros][metros]; // Creamos una matrix para llevar el registro  de las baldosas colocadas
	    int fila = 0; // Registro de la ultima fila en la que se coloca una baldosa
	    boolean disponible = false;
	    boolean puedeColocar = true;
	    Arrays.sort(tamaniosBaldosas); // Ordena de mayor a menor
	    for (int i = tamaniosBaldosas.length - 1; i >= 0; i--) { // Iterar sobre los tamaanos de las baldosas de mayor a menor
	        int tamanio = tamaniosBaldosas[i]; // Tomamos un entero para ir almacenadno el valor de los baldosa en ese momento
	        while (fila < metros) { // Colocamos un bucle while el cual, se ejecuta mientras exista un espacio disponible en la superficie del solar
	            disponible = false; // establecemos un boolean para indicar si se encontro un espacio disponible para la baldosa actual
	            for (int filas = 0; filas < metros - tamanio + 1 && !disponible; filas++) { // Recorremos las filas de la superficie
	                for (int columnas = 0; columnas < metros - tamanio + 1 && !disponible; columnas++) { // Recorremos las columnas de la superficie
	                    puedeColocar = true; // Se puede colocar la baldosa en la posicion actual
	                    for (int m = filas; m < filas + tamanio; m++) { // Filas que ocupa la baldosa
	                        for (int n = columnas; n < columnas + tamanio; n++) { // Columnas que ocupa la baldosa
	                            if (baldosasColocadas[m][n]) { // Si la posicion ya está ocupada por otra baldosa
	                                puedeColocar = false; // No se puede colocar
	                                break; // Salimos del bucle
	                            }
	                        }
	                        if (!puedeColocar) { // Si no se puede colocar la baldosa en la posicion actual
	                            break; // Salimos del bucle externo
	                        }
	                    }
	                    if (puedeColocar) { // Si se puede colocar la baldosa en la posicion actual
	                        for (int m = filas; m < filas + tamanio; m++) { // Iteramos sobre las filas que ocupa la baldosa
	                            for (int n = columnas; n < columnas + tamanio; n++) { // Iteracion sobre las columnas que ocupa la baldosa
	                                superficie[m][n] = tamanio; // Colocamos la baldosa en la posicion actual de la superficie
	                                baldosasColocadas[m][n] = true; // Marcamos la posicion como ocupada en la matriz de baldosas colocadas
	                                ultimaFila =m;
	                                ultimaColumna =n;
	                                primeraFila =filas;
	                                primeraColumna =columnas;
	                                ultimaBaldosa =tamaniosBaldosas[i];
	                            }
	                        }
	                        fila = filas + tamanio - 1; // Actrualizamos la variable 'fila' con la ultima fila en la que se coloco una baldosa
	                        disponible = true; // Indicamos que se encontro un espacio disponible para la baldosa actual
	                    }
	                }
	            }
	            if (!disponible) {
	                break;
	            }
	        }
	    }
	    ultimaFila += 1;
	    ultimaColumna +=1;
	    primeraFila +=1;
	    primeraColumna +=1;
	    System.out.println("Primera posicion: [" + primeraFila + "," + primeraColumna + "]");
	    System.out.println("ultima posicion: [" + ultimaFila + "," + ultimaColumna + "]");
	    System.out.println("Tamaño de baldosa: " + ultimaBaldosa + "x" + ultimaBaldosa);
	    return superficie;
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Metodo auxiliar para imprimir una matriz en la consola.
	 *
	 * @param matriz la matriz a imprimir.
	 */
	public static void imprimirMatriz(int[][] matriz) {
		for (int filas = 0; filas < matriz.length; filas++) { // recorremos las filas
			for (int columnas = 0; columnas < matriz[filas].length; columnas++) {	// recorremos las columnas
				System.out.print(matriz[filas][columnas] + " ");
			} // end for columnas
			System.out.println();
		} // end for filas
	}// end class

}
