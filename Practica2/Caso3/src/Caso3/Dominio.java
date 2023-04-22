package Caso3;
import java.util.*;

import subC_Pau.*;

public class Dominio {
    public static void dominio(int ladoFinca, int[] listadoLadoBaldosas) {
        ladoFinca = 9;
        int[][] finca = new int[ladoFinca][ladoFinca];        
        for (int i = 0 ; i < listadoLadoBaldosas.length; i++) {
        	Cultivo[] cultivos = {
            		new Cultivo (i)      	
            };
	        
	        // Ordenamos de mayor a menor
	        Arrays.sort(cultivos);
	        // Recorremos el array y lo pasado al metodo de distribucion de 
	        for (Cultivo cultivando : cultivos) {
	        	distribuirCultivos(finca, cultivando.getTam(),cultivando.getTam());        
	        }
	        // Imprimir el cuadrado inicial
	        for	( int j = 0; j < ladoFinca; j++) {
	        	for ( int k = 0; k < ladoFinca; k++ ) {
	        		System.out.print(" *");
	        	}
	        	System.out.println();
	        }
	        System.out.println("\n________________________________________________________________________\n");        
	        // Imprimir resultado
	        for (int l = 0; l < ladoFinca; l++) {
	            for (int j = 0; j < ladoFinca; j++) {
	            	// Verifica el valor de la posicion i,j en la matriz. 
	            	// 1) Si el valor es 0 entonces imprime '*' --> seccion vacía
	            	// 2) Si es diferente imprime el valor asignado
	                System.out.print(finca[l][j] == 0 ? " L" : " O");
	            }
	            System.out.println();
	        }
        }
    }    
    private static void distribuirCultivos(int[][] finca, int tamCultivo, int tamCultivoActual) {
        int ladoFinca = finca.length;
        int numCuadrosPorLado = ladoFinca / tamCultivo; // Calcular el número de cuadros por lado que se necesitan        
        // Iterar sobre cada cuadro de la finca
        for (int i = 0; i < numCuadrosPorLado; i++) {
            for (int j = 0; j < numCuadrosPorLado; j++) {
                boolean puedeColocar = true;                
                // Verificar que el espacio está libre
                for (int k = i * tamCultivo; k < (i + 1) * tamCultivo; k++) {
                    for (int l = j * tamCultivo; l < (j + 1) * tamCultivo; l++) {
                        if (finca[k][l] != 0) { // Si hay un cultivo ya en ese espacio
                            puedeColocar = false; // No se puede colocar el nuevo cultivo
                            break; // Salir del ciclo interno
                        }
                    }
                    if (!puedeColocar) break; // Si no se puede colocar, salir del ciclo externo
                }                
                // Colocar el cultivo
                if (puedeColocar) {
                    for (int k = i * tamCultivo; k < (i + 1) * tamCultivo; k++) {
                        for (int l = j * tamCultivo; l < (j + 1) * tamCultivo; l++) {
                            finca[k][l] = tamCultivoActual; // Asignar el tamaño del cultivo en cada espacio del cuadro
                        }
                    }
                }
            }
        }
    }
}
	/**
	 * Utilizamos la interfaz Comparable para implementar el método compareTo de dicha interfaz.
	 * En este caso, compareTo se usa para establecer un orden entre objetos y luego los comparamos, devolviendonos un valor si el
	 * objeto actual es menor, igual o mayor que el objeto comparado. 
	 * @see Comparable
	 * @author pauli
	 *
	 */
    class Cultivo implements Comparable<Cultivo> {
    	private int t;
    	// Getter y setter del compareTo para cultivo
    	public Cultivo(int t) {
    		this.t = t;
    	}
    	
    	public int getTam () {
    		return t;
    	}
    	@Override
    	public int compareTo(Cultivo otro) {
    		// Ordenar por tamaño de forma desendente.
    		return otro.t -t ;
    	}
    }