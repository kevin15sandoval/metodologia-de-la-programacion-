package Caso2;

import java.util.Arrays;

/**
 * Clase que usa la ordenaci�n por combinaci�n.
 * 
 * B�sicamente, cada elemento del array dato, 'datos', cuenta todos los elementos m�s que a su izquierda y agrega el conteo a la salida.
 * Toda la magia ocurre dentro de la funci�n de combinaci�n de clasificaci�n de combinaci�n.
 */
/**
 * @version 0.2
 * @author paulino
 */
public class Paulino {

	public static int mergesort(int[] datos, int inicio, int finD) {
		int[] copia = Arrays.copyOf(datos, datos.length);
		/*
		 *  Nos dan como base los datos de entrada con los que trabajaremos. --> int[] datos.
		 *  Y una copia del array --> int[] copy.
		 *
		 * Buscamos y resolvemos el caso base: Tama�o de ejecuci�n <= 1
		 */
		if (finD <= inicio ) {
			return 0;
		}
		/*
		 *   Encontramos el punto medio del problema.
		 *   Usamos la t�cnica de bit shifting: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
		 *   
		 *   Comenzamos restando inicio de fin para obtener la longitud del intervalo. Luego, este valor, se divide entre 2 mediante el operador '>>', que realiza un despllazamiento
		 *   hacia la derecha en la representaci�n binaria del n�mero, lo que es equivalente a una divisi�n por 2^n, donde 'n' es el n�mero de bits que se desplazan.
		 *   
		 *   El resultado se suma a inicio para obtener un valor medio, que se almacena en 'mitad', un entero que representa el �ndice medio del  int�rvalo del array datos.
		 */
		int mitad = ( inicio + ((finD - inicio ) >> 1 ));
		int inversionEncontrada = 0;
		/*
		 * Dividimos recursivamente las ejecuciones en dos mitades hasta que las divisiones sean <= 1.
		 * Luego se unen y devuelven al array original
		 */

		// Dividimos la mitad izquierda
		inversionEncontrada += mergesort(datos , inicio, mitad );
		// Dividimos la mitad derecha
		inversionEncontrada += mergesort(datos , mitad +1 , finD );
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
		 * No es necesario copiar la segunda mitad, pues los numeros restantes est�n en su posici�n correcta en el array copy.
		 * 
		 *  Copia el nuevo orden de nuevo  al array original 
		 */
		for ( inicio = min; inicio <= max; inicio++  ) {
			datos[inicio] = aux[inicio];
		}

		return inversionEncontrada;
	}
	
}
