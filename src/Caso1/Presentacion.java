package Caso1;

import java.util.Scanner;

/**
 * <h1>Prácticas. Caso de estudio 1.</h1>
 * <p>
 *     <h2>Problema.</h2>
 *     <p>
 *         Un número hexagonal es un número poligonal que representa un hexágono. La expresión para calcular el n-ésimo número hexagonal es
 *         <div>
 *             <img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/5934056aa3c555c0656808428d27b21e673861b0" alt="">
 *         </div>
 *         Otra forma de obtener el enésimo número hexagonal n también puede expresarse a través de la siguiente suma:
 *         <div>
 *             <img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/91a4c4d6f5dfd958b0010695ced89828bea54009" alt="">
 *         </div>
 *         Se pide:
 *         – Determinar la relación de recurrencia correspondiente a la ecuación (2).
 *         – Determinar teóricamente la complejidad de los tres algoritmos.
 *         – Implementar los tres algoritmos en un programa en Java.
 *         – Determinar empíricamente el tiempo de ejecución de los tres algoritmos como función de n.
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
        		System.out.println("Introduce qué número hexagonal quieres calcular: ");
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
    	System.out.println("Aplicación del método directo, mediante fórmula:");
        FormulaDirecta.formulaDirecta(entrada);        
    }
    public static void opcion2(int entrada) {
    	System.out.println("Aplicación del método recursivo:");
        Recursivo.recursivo(entrada);        
    }
    public static void opcion3(int entrada) {
    	System.out.println("Aplicación del método iterativo:");
        Iteracion.iteracion(entrada);        
    }
    public static void salir() {
    	Interfaz.finPrograma();    
	}
    public static void opcionNoExiste() {
    	Interfaz.opcionNoExiste();    
	}
    
}
