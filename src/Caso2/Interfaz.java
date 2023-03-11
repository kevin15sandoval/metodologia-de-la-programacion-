/**
 * Interfaz de usuario del caso 1.
 * ===============================
 * Contenido.
 * ===============================
 */
package Caso2;

import java.util.Scanner;

/**
 * @author Paulino
 * @version 0.1
 */
public interface Interfaz {
	String usuario = System.getProperty("user.name");
	public static String FICHERO_DATOS = "InversionsTest_12.dat";	
	public static void interfaz() {}
	public static void bienvenida() {
		System.out.println("******************************************************************************************************************************");
		System.out.printf("**   Bienvenido %s al segundo caso. - Numeros de inversiones ***\n", usuario);
		System.out.println("******************************************************************************************************************************\n");        
	}
	public static int pedirOpcion() {
		int entrada = 0;		
		/* ---------------------------------------------------------------- */
		System.out.println("Selecciona una de las opciones disponibles: ");
		System.out.println("1- Andres.");
        System.out.println("2- German.");
        System.out.println("3- Kevin.");
        System.out.println("4- Paulino.");        
        System.out.println("5- Finalizar programa.");
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
	public static void opcionNoExiste() {
		System.out.println();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! WARNING !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.printf(" \t\t %s la opcion que escribiste, no existe, vuelve a intentarlo de nuevo \n");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Main.inicioPrograma();
		
	}
}
