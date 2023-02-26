/**
 * Interfaz de usuario del caso 1.
 * ===============================
 * Contenido.
 * ===============================
 */
package Caso1;

import java.util.Scanner;

/**
 * @author Paulino
 * @version 0.1
 */
public interface Interfaz {
	String usuario = System.getProperty("user.name");
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
		System.out.println( usuario + " Gracias por usar nuestro programa de Numeros Hexagonales.");
		System.exit(0);
	}
	
	public static void opcionNoExiste() {
		System.out.println();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! WARNING !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.printf(" \t\t %s la opcion que escribiste, no existe, vuelve a intentarlo de nuevo \n");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Presentacion.inicioPrograma();
		
	}
}
