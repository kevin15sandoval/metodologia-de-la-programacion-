package Caso1;

import java.util.Scanner;

/**
 * <h1>Pr�cticas. Caso de estudio 1.</h1>
 * <p>
 *     <h2>Problema.</h2>
 *     <p>
 *         Un n�mero hexagonal es un n�mero poligonal que representa un hex�gono. La expresi�n para calcular el n-�simo n�mero hexagonal es
 *         <div>
 *             <img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/5934056aa3c555c0656808428d27b21e673861b0" alt="">
 *         </div>
 *         Otra forma de obtener el en�simo n�mero hexagonal n tambi�n puede expresarse a trav�s de la siguiente suma:
 *         <div>
 *             <img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/91a4c4d6f5dfd958b0010695ced89828bea54009" alt="">
 *         </div>
 *         Se pide:
 *         � Determinar la relaci�n de recurrencia correspondiente a la ecuaci�n (2).
 *         � Determinar te�ricamente la complejidad de los tres algoritmos.
 *         � Implementar los tres algoritmos en un programa en Java.
 *         � Determinar emp�ricamente el tiempo de ejecuci�n de los tres algoritmos como funci�n de n.
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
        		System.out.println("Introduce qu� n�mero hexagonal quieres calcular: ");
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
    	System.out.println("Aplicaci�n del m�todo directo, mediante f�rmula:");
        FormulaDirecta.formulaDirecta(entrada);        
    }
    public static void opcion2(int entrada) {
    	System.out.println("Aplicaci�n del m�todo recursivo:");
        Recursivo.recursivo(entrada);        
    }
    public static void opcion3(int entrada) {
    	System.out.println("Aplicaci�n del m�todo iterativo:");
        Iteracion.iteracion(entrada);        
    }
    public static void salir() {
    	Interfaz.finPrograma();    
	}
    public static void opcionNoExiste() {
    	Interfaz.opcionNoExiste();    
	}
    
}
