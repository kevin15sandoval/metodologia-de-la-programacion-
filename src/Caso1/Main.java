package Caso1;

import java.util.Scanner;

/**
 * Practicas. Caso de estudio 1.
 * 
 * Problema.
 *         Un numero hexagonal es un numero poligonal que representa un hexagono. La expresion para calcular el n-esimo numero hexagonal es
 *
 *             <img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/5934056aa3c555c0656808428d27b21e673861b0" alt="">
 *         Otra forma de obtener el enesimo numero hexagonal n tambien puede expresarse a traves de la siguiente suma:
 *             <img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/91a4c4d6f5dfd958b0010695ced89828bea54009" alt="">
 *         Se pide:
 *         - Determinar la relacion de recurrencia correspondiente a la ecuacion (2).
 *         - Determinar teoricamente la complejidad de los tres algoritmos.
 *         - Implementar los tres algoritmos en un programa en Java.
 *         - Determinar empiricamente el tiempo de ejecucion de los tres algoritmos como funcion de n.
 */
/*
 * @author Paulino
 * @version 0.1
 */
public class Main {
	static double a = 0;
	static double b = 0;
	/**
	 * Programa principal
	 */
    public static void main(String[] args) {
        do {
        	inicioPrograma();
        }while(true);
        	
    }
    /**
     * Inicio del programa
     */
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
    /**
     * metodo de formula directa
     * @param entrada
     */
    public static void opcion1(int entrada) {    	
    	a = Interfaz.tiempoEjecucion();
    	//System.out.println(a);
    	System.out.println("Aplicacion del metodo directo, mediante formula:");
        System.out.println(Dominio.formulaDirecta(entrada));
        b = Interfaz.tiempoEjecucion();
        // System.out.println(b);
        System.out.println();
        System.out.println("Resultado final: "+ (b-a) + "ns");
    }
    /**
     * metodo recursivo
     * @param entrada
     */
    public static void opcion2(int entrada) {
    	a = Interfaz.tiempoEjecucion();
    	System.out.println("Aplicacion del metodo recursivo:");
    	System.out.println(Dominio.recursivo(entrada));
    	// System.out.print(Interfaz.tiempoEjecucion());
        b = Interfaz.tiempoEjecucion();
        //System.out.println(b);
        System.out.println();
        System.out.println("Resultado final: "+ (b-a) + "ns");
    }
    /**
     * metodo iterativo
     * @param entrada
     */
    public static void opcion3(int entrada) {
    	System.out.println("Aplicacion del metodo iterativo:");
    	System.out.println(Dominio.iteracion(entrada));
    	// System.out.print(Interfaz.tiempoEjecucion());
        b = Interfaz.tiempoEjecucion();
        // System.out.println(b);
        System.out.println();
        System.out.println("Resultado final: "+ (b-a) + "ns");
    }
    /**
     *  Metodo salir del programa
     */
    public static void salir() {
    	Interfaz.finPrograma();    
	}
    /**
     * Opcion no existe
     */
    public static void opcionNoExiste() {
    	Interfaz.opcionNoExiste();    
	}
    
}
