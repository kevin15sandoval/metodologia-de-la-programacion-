package Caso2;

import java.util.Arrays;

/**
 * Clase que usa la ordenación por combinación.
 * 
 * Básicamente, cada elemento del array dato, 'datos', cuenta todos los elementos más que a su izquierda y agrega el conteo a la salida.
 * Toda la magia ocurre dentro de la función de combinación de clasificación de combinación.
 */
/**
 * @version 0.2
 * @author paulino
 */
public class Paulino {

	public static int mergesort(int[] datos, int[] copia, int inicio, int finD) {
		/*
		 *  Nos dan como base los datos de entrada con los que trabajaremos. --> int[] datos.
		 *  Y una copia del array --> int[] copy.
		 *
		 * Buscamos y resolvemos el caso base: Tamaño de ejecución <= 1
		 */
		if (finD <= inicio ) {
			return 0;
		}
		/*
		 *   Encontramos el punto medio del problema.
		 *   Usamos la técnica de bit shifting: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
		 *   
		 *   Comenzamos restando inicio de fin para obtener la longitud del intervalo. Luego, este valor, se divide entre 2 mediante el operador '>>', que realiza un despllazamiento
		 *   hacia la derecha en la representación binaria del número, lo que es equivalente a una división por 2^n, donde 'n' es el número de bits que se desplazan.
		 *   
		 *   El resultado se suma a inicio para obtener un valor medio, que se almacena en 'mitad', un entero que representa el índice medio del  intérvalo del array datos.
		 */
		int mitad = ( inicio + ((finD - inicio ) >> 1 ));
		int inversionEncontrada = 0;
		/*
		 * Dividimos recursivamente las ejecuciones en dos mitrades hasta que las divisiones sean <= 1.
		 * Luego se unen y devuelven al array original
		 */

		// Dividimos la mitad izquierda
		inversionEncontrada += mergesort(datos, copia , inicio, mitad );
		// Dividimos la mitad derecha
		inversionEncontrada += mergesort(datos, copia , mitad +1 , finD );
		// Unimos las dos mitades recorridas
		inversionEncontrada +=merge(datos, copia, inicio, mitad, finD);
		
		// Devolvemos las inversiones realizadas
		return inversionEncontrada;
	}
	private static int merge(int[] datos, int[] aux, int min, int mid, int max) {
		int inicio = min, i = min, mitad = mid+1, fin = max;
		int inversionEncontrada = 0;
		/*
		 * Mientras existan elementos en los array, continuamos 
		 */
		while ( inicio <= mid && mitad <= fin) {
			if(datos[inicio]<=datos[mitad]) {
				aux[i++]=datos[inicio++]; 
			} else {
				aux[i++]=datos[mitad++];
				inversionEncontrada += (mid - inicio +1);
			}				
		}
		// Copiamos los elementos restantes que ya vienen ordenados en el array
		while ( inicio <= mid ) {
			aux[i++] = datos[inicio++];
		}
		/*
		 * No es necesario copiar la segunda mitad, pues los numeros restantes están en su posición correcta en el array copy.
		 * 
		 *  Copia el nuevo orden de nuevo  al array original 
		 */
		for ( inicio = min; inicio <= max; inicio++  ) {
			datos[inicio] = aux[inicio];
		}
		return inversionEncontrada;
	}
	
}
