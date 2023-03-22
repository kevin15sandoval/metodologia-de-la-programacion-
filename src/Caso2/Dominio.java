package Caso2;
/**
 * Clase de Dominio.
 * 
 * Contiene los métodos necesarios para calcular las inversiones.
 *
 * @author: Kevin Gomez
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
	        if (izquierda < derecha) {
	            int mitad = (izquierda + derecha) / 2;
	            contador += mergeSort(array, izquierda, mitad);
	            contador += mergeSort(array, mitad + 1, derecha);
	            contador += merge(array, temporal, izquierda, mitad, derecha);
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
	        long contador = 0;
	        int i = izquierda, j = mitad + 1, k = izquierda;
	        while (i <= mitad && j <= derecha) {
	            if (array[i] <= array[j]) {
	                temporal[k++] = array[i++];
	            } else {
	                temporal[k++] = array[j++];
	                contador += mitad - i + 1; // Contabiliza las inversiones
	            }
	        }
	        while (i <= mitad) {
	            temporal[k++] = array[i++];
	        }
	        while (j <= derecha) {
	            temporal[k++] = array[j++];
	        }
	        for (i = izquierda; i <= derecha; i++) {
	            array[i] = temporal[i];
	        }
	        
	        return contador;
	    }

}
