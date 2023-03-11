package Caso2;

import java.util.Scanner;

/**
 * <h1>Practicas. Caso de estudio 2.</h1>
 * <h2>Descripci�n del problema</h2>
 * <p>
 * Algunos sitios Web hacen uso de una t�cnica conocida como filtrado colaborativo.
 * Con ella, estos sitios intentan hacer concordar nuestras preferencias con las de otros usuarios. Una vez que el sitio Web ha identificado individuos con preferencias similares a
 * las nuestras -bas�ndose en la comparaci�n de c�mo los usuarios hemos puntuado o calificado determinados productos- puede recomendarnos nuevos productos que los otros
 * usuarios hayan apreciado. Por ejemplo, un sitio de m�sica puede intentar emparejar nuestras preferencias musicales con las de otros usuarios de la forma siguiente:
 * 
 * 		� Nosotros clasificamos n canciones
 * 		� El sitio Web consulta su base de datos para encontrar usuarios con gustos similares
 * 
 * El punto principal en una aplicaci�n como esta es el problema de c�mo comparar dos clasificaciones (rankings). Es decir, �c�mo se determina la semejanza de dos rankings?
 * Un m�todo directo ser�a clasificar n canciones (o el producto del que se trate) de 1 a n en funci�n de nuestras preferencias. Ahora, comparamos con la otra clasificaci�n
 * determinando cuantas parejas est�n �descolocadas�. Por ejemplo, en el caso de las canciones:
 * 		- Nuestra clasificaci�n (la referencia): 1, 2, �, n
 * 		- Otra clasificaci�n: a1, a2, �, an
 * 		- Las canciones i and j est�n invertidas (�descolocadas�) si i < j, pero ai > aj
 * Por tanto, Podemos usar como m�trica de semejanza (o diferencia) el n�mero de inversiones entre las dos clasificaciones, ver el ejemplo siguiente:
 * 
 * <img src="
 * 
 * Problema.
 *    Dada una permutaci�n contar el n�mero de inversiones
 *
 * @author Paulino
 * @version 0.1
 */
public class Main {
	static double a = 0;
	static double b = 0;
	
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
        	if ( opcion != 5 ) {
        		System.out.println("Introduce que numero hexagonal quieres calcular: ");
            	@SuppressWarnings("resource")
    			Scanner dato = new Scanner(System.in);
            	numero = dato.nextInt();
        	}
            switch (opcion) {
            	case 1 -> opcion1(); // Descomentar andres()
            	case 2 -> opcion2(); // descomentar german()
            	case 3 -> opcion3(); // Descomentar kevin()
            	case 4 -> opcion4(); // paulino()
            	case 5 -> salir();
            	default -> opcionNoExiste();
            }
        } catch( Exception e) {
        	System.out.println("Error: " + e);
        }        
    }
    public static void opcion1() {    	
    	a = Interfaz.tiempoEjecucion();
    	// Andres.mergesort();
        b = Interfaz.tiempoEjecucion();  
        System.out.println();
        System.out.println("Resultado final: "+ (b-a) + "ns");
    }
    public static void opcion2() {
    	a = Interfaz.tiempoEjecucion();
    	// German.mergesort();
        b = Interfaz.tiempoEjecucion();
        System.out.println();
        System.out.println("Resultado final: "+ (b-a) + "ns");
    }
    public static void opcion3() {
    	a = Interfaz.tiempoEjecucion();
    	// Kevin.mergesort();
    	b = Interfaz.tiempoEjecucion();
        System.out.println();
        System.out.println("Resultado final: "+ (b-a) + "ns");
    }
    public static void opcion4() {
    	a = Interfaz.tiempoEjecucion();
    	// Paulino.mergesort();
    	b = Interfaz.tiempoEjecucion(); 
        System.out.println();
        System.out.println("Resultado final: "+ (b-a) + "ns");
    }
    public static void salir() {
    	Interfaz.finPrograma();    
	}
    public static void opcionNoExiste() {
    	Interfaz.opcionNoExiste();    
	}
    
}
