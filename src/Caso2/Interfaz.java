/**
 * Interfaz de usuario del caso 1.
 * ===============================
 * Contenido.
 * ===============================
 */
package Caso2;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Paulino
 * @version 0.1
 */
public interface Interfaz {
	String usuario = System.getProperty("user.name");
	// Fichero con los datos de entrada	
	public static String FICHERO_DATOS = "src/Caso2/Data/InversionsTest_6.dat";
	// Metodos de la interfaz
	public static void interfaz() {}
	public static void bienvenida() {
		System.out.println("********************************************************************************");
		System.out.printf("**   Bienvenido %s al segundo caso. - Numeros de inversiones ***\n", usuario);
		System.out.println("********************************************************************************\n");        
	}
	public static int pedirOpcion() {
		int entrada = 0;		
		/* ---------------------------------------------------------------- */
		System.out.println("Selecciona una de las opciones disponibles: ");
		System.out.println("");
		System.out.println("Inversion programada por: ");
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
		System.out.println( usuario + " gracias por usar nuestro programa de Numero de Inversiones.");
		System.exit(0);
	}
	public static double tiempoEjecucion() {
		double timer = System.nanoTime();
		return timer;
	}
	public static void opcionNoExiste() {
		System.out.println();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! WARNING !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.printf(" \t %s la opcion que escribiste, no existe, vuelve a intentarlo de nuevo \n",usuario);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Main.inicioPrograma();		
	}
	public static void animacion() throws IOException, InterruptedException {
		System.out.print(""" 
				____     ___   ____   ____     ___       ___                    ___       ___________   
				`MM'     `M'  6MMMMb/ `MM'     `MMb     dMM'                    `MMb     dMM'`MMMMMMMb. 
				 MM       M  8P    YM  MM       MMM.   ,PMM                      MMM.   ,PMM  MM    `Mb 
				 MM       M 6M      Y  MM       M`Mb   d'MM                      M`Mb   d'MM  MM     MM 
				 MM       M MM         MM       M YM. ,P MM                      M YM. ,P MM  MM     MM 
				 MM       M MM         MM       M `Mb d' MM                      M `Mb d' MM  MM    .M9 
				 MM       M MM         MM       M  YM.P  MM                      M  YM.P  MM  MMMMMMM9' 
				 MM       M MM         MM       M  `Mb'  MM       MMMMMMM        M  `Mb'  MM  MM        
				 YM       M YM      6  MM       M   YP   MM                      M   YP   MM  MM        
				  8b     d8  8b    d9  MM    /  M   `'   MM                      M   `'   MM  MM        
				   YMMMMM9    YMMMM9  _MMMMMMM _M_      _MM_                    _M_      _MM__MM_  
				   				
				   								
				   																""");
		String anim= "|··>"; for (int x =0 ; x < 10 ; x++) { 
			String data = "\t" + anim.charAt(x % anim.length()) + " " + x ; System.out.write(data.getBytes()); Thread.sleep(100);		
		}
		System.out.println();
	}
}
