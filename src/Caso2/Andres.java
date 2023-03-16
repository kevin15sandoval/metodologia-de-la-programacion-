package Caso2;
/**
 * 
 * @author Andres Diaz0
 *
 */
public class Andres {

	public static void mergesort(int[] d) {
	int a = d.length/2; // hacemos la division del array en dos partes
	int c = a; //cogemos la posicion intermedia del array
	int e = 0; // hacemos una variable que sea el inicio del array
	int cont = 0; //hacemos una variable que sea la suma de inversiones
	int f = 0; //aqui queda el resultado de la resta de las dos partes del array
	for (int b = 0; b <= a; b++) { //hacemos un bucle que se repita el mismo numero de veces que la mitad del array 
		if (d[e] < d[c]) { //si el valor de la primera parte del array es mas pequeña que la segunda
			e++; //se le suma en una posicion a la primera parte del array 
		} else { //en caso contrario
			f = c - e; //se hace la resta de las dos partes del array para sacar el valor de la inversion
			c++; //se le suma en una posicion a la segunda parte del array
		}
		cont = cont + f; //se le hace la suma de las inversiones
	}
	System.out.print(cont); //se escribe el valor total de la inversion
	}

}
