package Caso1;

import java.util.Scanner;

/**
 * <h1>Practicas. Caso de estudio 1.</h1>
 * <p>
 *     <h2>Problema.</h2>
 *     <p>
 *         Un numero hexagonal es un numero poligonal que representa un hexagono. La expresion para calcular el n-esimo numero hexagonal es
 *         <div>
 *             <img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/5934056aa3c555c0656808428d27b21e673861b0" alt="">
 *         </div>
 *         Otra forma de obtener el enesimo numero hexagonal n tambien puede expresarse a traves de la siguiente suma:
 *         <div>
 *             <img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/91a4c4d6f5dfd958b0010695ced89828bea54009" alt="">
 *         </div>
 *         Se pide:
 *         - Determinar la relacion de recurrencia correspondiente a la ecuacion (2).
 *         - Determinar teoricamente la complejidad de los tres algoritmos.
 *         - Implementar los tres algoritmos en un programa en Java.
 *         - Determinar empiricamente el tiempo de ejecucion de los tres algoritmos como funcion de n.
 *     </p>
 * </p>
 *
 * @author Paulino
 * @version 0.1
 */
public class Presentacion {
    public static void main(String[] args) {
        do {
        	inicioPrograma();
        }while(true);
        	
    }
    public static void inicioPrograma() {    	
    	int numero = 0, opcion = 0;
        Interfaz.bienvenida();
        opcion = Interfaz.pedirOpcion();        
    	try {
        	if ( opcion != 4 ) {
        		System.out.println("Introduce que numero hexagonal quieres calcular: ");
            	@SuppressWarnings("resource")
    			Scanner dato = new Scanner(System.in);
            	numero = dato.nextInt();
        	}
            switch (opcion) {
            	case 1 -> opcion1(numero);
            	case 2 -> opcion2(numero);
            	case 3 -> opcion3(numero);
            	case 4 -> salir();
            	default -> opcionNoExiste();
            }
        } catch( Exception e) {
        	System.out.println("Error: " + e);
        }        
    }
    public static void opcion1(int entrada) {
    	System.out.println("Aplicacion del metodo directo, mediante formula:");
        FormulaDirecta.formulaDirecta(entrada);        
    }
    public static void opcion2(int entrada) {
    	System.out.println("Aplicacion del metodo recursivo:");
        Recursivo.recursivo(entrada);        
    }
    public static void opcion3(int entrada) {
    	System.out.println("Aplicacion del metodo iterativo:");
        Iteracion.iteracion(entrada);        
    }
    public static void salir() {
    	Interfaz.finPrograma();    
	}
    public static void opcionNoExiste() {
    	Interfaz.opcionNoExiste();    
	}
    
}
