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
        bienvenida();
        opcion = pedirOpcion();        
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
    	a = tiempoEjecucion();
    	//System.out.println(a);
    	System.out.println("Aplicacion del metodo directo, mediante formula:");
        System.out.println(Dominio.formulaDirecta(entrada));
        b = tiempoEjecucion();
        // System.out.println(b);
        System.out.println();
        System.out.println("Resultado final: "+ (b-a) + "ns");
    }
    /**
     * metodo recursivo
     * @param entrada
     */
    public static void opcion2(int entrada) {
    	a = tiempoEjecucion();
    	System.out.println("Aplicacion del metodo recursivo:");
    	System.out.println(Dominio.recursivo(entrada));
    	// System.out.print(tiempoEjecucion());
        b = tiempoEjecucion();
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
    	// System.out.print(tiempoEjecucion());
        b = tiempoEjecucion();
        // System.out.println(b);
        System.out.println();
        System.out.println("Resultado final: "+ (b-a) + "ns");
    }
    /**
     *  Metodo salir del programa
     */
    public static void salir() {
    	finPrograma();    
	}
    /**
     * Opcion no existe
     */

	public static void opcionNoExiste() {
		System.out.println();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! WARNING !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.printf(" \t %s la opcion que escribiste, no existe, vuelve a intentarlo de nuevo \n", usuario);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Main.inicioPrograma();
		
	}
    
    // --------------------- METODOS DE LA INTERFAZ --------------------------------------------------
    

	private static String usuario = System.getProperty("user.name");
	public static void interfaz() {}
	public static void bienvenida() {
		System.out.println("******************************************************************************************************************************");
		System.out.printf("**   Bienvenido %s al primer caso. - Numeros Hexagonales ***\n", usuario);
		System.out.println("******************************************************************************************************************************\n");        
	}
	public static int pedirOpcion() {
		int entrada = 0;		
		/* ---------------------------------------------------------------- */
		System.out.println("Selecciona una de las opciones disponibles: ");
		System.out.println("1- Por formula.");
        System.out.println("2- Por recursividad.");
        System.out.println("3- Por iteracion.");
        System.out.println("4- Finalizar programa.");
        System.out.print("");
        /* ---------------------------------------------------------------- */
        @SuppressWarnings("resource")		
		Scanner dato = new Scanner(System.in);
        entrada = dato.nextInt();
        /* ---------------------------------------------------------------- */
        return entrada;
	}
	public static void finPrograma() {	
		System.out.println();
		System.out.println("Fin del programa!");
		System.out.println( usuario + " gracias por usar nuestro programa de Numeros Hexagonales.");
		System.exit(0);
	}
	public static double tiempoEjecucion() {
		double timer = System.nanoTime();
		return timer;
	}
}
