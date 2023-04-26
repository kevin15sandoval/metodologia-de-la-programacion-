package CasoExtra;
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
	        if (izquierda < derecha) {
	            int mitad = (izquierda + derecha) / 2;
	            contador += mergeSort(array, izquierda, mitad);
	            contador += mergeSort(array, mitad + 1, derecha);
	            contador += merge(array, temporal, izquierda, mitad, derecha);
	        }
	        return contador;
	    }
	    /**
	     * MERGE MODIFICADO.
	     * Realizamos un if exclusivo para detectar el valor '1' o '2', para que fuesen los únicos que realicen el conteo de las inversiones.
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
<<<<<<< HEAD:Hito-1/src/CasoExtra/Dominio.java
	            	temporal[k++] = array[j++];	            	
	                if ( i == 1 || i== 2 ) {	                	
=======
	            	temporal[k++] = array[j++];		            	
	                if ( i == 1 ) {	                	
>>>>>>> 2b7f0b8151f1e13a81e65cf5e01e6e522807ebde:src/CasoExtra/Dominio.java
	                	contador += mitad - i + 1; // Contabiliza las inversiones
	                } 
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
