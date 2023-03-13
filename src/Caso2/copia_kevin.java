package Caso2;
import java.util.Scanner;

public class copia_kevin {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
			 Scanner sc = new Scanner(System.in);
		      System.out.print("Ingrese el tamanoaño del array: ");
		      int tamano = sc.nextInt();
		      
		      int[] numeros = new int[tamano];
		      
		      for (int i = 0; i < tamano; i++) {
		         System.out.print("Ingrese el valor para la posición " + i + ": ");
		         numeros[i] = sc.nextInt();
		      }
		      long inversiones = contarInversiones(numeros);
		      System.out.println("Hay un total de " + inversiones + " inversiones en este array");
		}
		
		/*
			 *  llama al algoritmo de "merge sort". Recibe un arreglo de enteros y
			 *   devuelve el número total de inversiones en el array.
			 */
		    public static long contarInversiones(int[] array) {
		    	//creamos un array temporal que luego nos ayudara para ordenar el array original por ello su tmañano es igual al del array
		    	int[] temporal = new int[array.length];
		    	
		    	//regresamosel metodo mergeSorte porque es el que no dara el numero de inversiones de nuestro array
		        return mergeSort(array, temporal, 0, array.length - 1);
		    }
		    /*
		     *  Es la función de "división" que divide el array en dos mitades y 
		     * llama recursivamente a mergeSort en ambas mitades hasta que el tamanoaño de la mitad es uno.
		     */
		    private static long mergeSort(int[] array, int[] temporal, int izquierda, int derecha) {
		    
		       //Inicializamos el contador a 0 porque este nos llevara la cuenta del numeor de inversores en nuetsro array
		    	long contador = 0;
		    	//
		        if (izquierda < derecha) {
		            int mitad = (izquierda + derecha) / 2;
		            contador += mergeSort(array, temporal, izquierda, mitad);
		            contador += mergeSort(array, temporal, mitad + 1, derecha);
		            contador += merge(array, temporal, izquierda, mitad, derecha);
		        }
		        return contador;
		    }
		    /*
		     * La función merge es la función de "mezcla" que mezcla las dos mitades y cuenta el número de inversiones en el proceso.
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
