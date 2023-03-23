package Caso2;
/**
 * Clase de Dominio.
 * 
 * Contiene los métodos necesarios para calcular las inversiones.
 *
 * @author: 
 */
public class Dominio {	
		
		
		/**
		 * mergerSort.
		 * Es la funcion de "division" que divide el array en dos mitades y 
	     * llama recursivamente a mergeSort en ambas mitades hasta que el tamano de la mitad es uno.
		 * @param array
		 * @param izquierda
		 * @param derecha
		 * @return contador
		 */
	    public static long mergeSort(int[] array,  int izquierda, int derecha) {
	    	//creamos un array temporal que luego nos ayudara para ordenar el array original por ello su tamano es igual al del array
	    	int[] temporal = new int[array.length];
	       //Inicializamos el contador a 0 porque este nos llevara la cuenta del numeor de inversores en nuetsro array
	    	long contador = 0;
	    	//
	        if (izquierda < derecha) {//si el valor de la izquirda es menor al de la derecha entramos en el if
	            int mitad = (izquierda + derecha) / 2; //dividimos el array en dos mitades
	         // llamamos de nuevo el metodo mergesort para ir dividiendo nuestro array hasta que este ya no se pueda dividir, en este caso el de la izquierda
	            contador += mergeSort(array, izquierda, mitad); 
	         //// llamamos de nuevo el metodo mergesort para ir dividiendo nuestro array hasta que este ya no se pueda dividir, en este caso el de la derecha
	            contador += mergeSort(array, mitad + 1, derecha);
	            //llamamos al metodo merge para ahora ir uniendo las mitados hasta llegar a un unico array ordenado 
	            contador += merge(array, temporal, izquierda, mitad, derecha);
	            //durante todo este proceso vamos contabilizando las inversiones, ya que luego devolveremos la inversiones totales
	        }
	        return contador;
	    }
	    /**
	     * merge.
	     * La funcion merge es la funcion de "mezcla" que mezcla las dos mitades y cuenta el numero de inversiones en el proceso.
	     * @param array
	     * @param temporal
	     * @param izquierda
	     * @param mitad
	     * @param derecha
	     * @return contador
	     */
	    private static long merge(int[] array, int[] temporal, int izquierda, int mitad, int derecha) {
	    	//inializamos el contador a cero, este es el que nos contara si encontramos alguna inversion
	        long contador = 0;
	        int i = izquierda, j = mitad + 1, k = izquierda;
	        //llevamos a cabo una serie de bucles while's
	        //el primer bucle while si el variable i  es menor que la mitad y la j es menor que la derecha 
	        while (i <= mitad && j <= derecha) {
	        	//si el array en la posicion i es menor o igual que el de la psosicon j entonces en nuestro array temporal
	        	//en la posicion  k copiara  lo de la posicion i de nuestro array y posteriormete tanto k y j se inrementn
	            if (array[i] <= array[j]) {
	                temporal[k++] = array[i++];
	                //en el caso contrario sucede lo mismo solo que se copia lo de la posicion j y nos inidica si ha habido una inversion
	            } else {
	                temporal[k++] = array[j++];
	                contador += mitad - i + 1; // Contabiliza las inversiones
	            }
	        }
	        //  en el caso de que no se cumpla la condicion del while anterior establecemos dos while uno para condicion 
	        //individual para ir colocando el elemento correspondinte en nuetsro array temporal que luego sera copidado
	        //por nuestro array original
	        while (i <= mitad) {
	            temporal[k++] = array[i++];
	        }
	        while (j <= derecha) {
	            temporal[k++] = array[j++];
	        }
	        //recorremos los arrays y vamos copiando el array temporal en nuestro array original
	        for (i = izquierda; i <= derecha; i++) {
	            array[i] = temporal[i];
	        }
	        
	        return contador;
	    }

}
