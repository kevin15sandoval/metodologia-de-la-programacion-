package Caso2;

/**
 * <h1>Practicas. Caso de estudio 2.</h1>
 * <h2>Descripción del problema</h2>
 * <p>
 * Algunos sitios Web hacen uso de una técnica conocida como filtrado colaborativo.
 * Con ella, estos sitios intentan hacer concordar nuestras preferencias con las de otros usuarios. Una vez que el sitio Web ha identificado individuos con preferencias similares a
 * las nuestras -basándose en la comparación de cómo los usuarios hemos puntuado o calificado determinados productos- puede recomendarnos nuevos productos que los otros
 * usuarios hayan apreciado. Por ejemplo, un sitio de música puede intentar emparejar nuestras preferencias musicales con las de otros usuarios de la forma siguiente:
 * 
 * 		• Nosotros clasificamos n canciones
 * 		• El sitio Web consulta su base de datos para encontrar usuarios con gustos similares
 * 
 * El punto principal en una aplicación como esta es el problema de cómo comparar dos clasificaciones (rankings). Es decir, ¿cómo se determina la semejanza de dos rankings?
 * Un método directo sería clasificar n canciones (o el producto del que se trate) de 1 a n en función de nuestras preferencias. Ahora, comparamos con la otra clasificación
 * determinando cuantas parejas están “descolocadas”. Por ejemplo, en el caso de las canciones:
 * 		- Nuestra clasificación (la referencia): 1, 2, …, n
 * 		- Otra clasificación: a1, a2, …, an
 * 		- Las canciones i and j están invertidas (“descolocadas”) si i < j, pero ai > aj
 * Por tanto ver el ejemplo siguiente:
 * @see<a href="https://campusvirtual.uclm.es/pluginfile.php/5769295/mod_resource/content/28/CasoEstudio2_MP_2022_23.pdf" target="_blank" rel="noopener noreferrer">Recuento de inversion de un array - Explicación completa del problema.</a>
 * 
 * Problema.
 *    Dada una permutación contar el número de inversiones.
 */
 /*
 * @author Paulino
 * @version 0.1
 */
public class Main {
	private static double a = 0;
	private static double b = 0;
	
    public static void main(String[] args) {
        do {
        	inicioPrograma();
        }while(true);
        	
    }
    public static void inicioPrograma() {

    	// Variables necesarias para interactuar con el usuario
    	int[] dEntrada = null;
    	int opcion = 0;
    	
    	// ------------------------------------------------------------------
    	// Mensaje de bienvenida.
        Interfaz.bienvenida();
        // Selecciónar opcion del programa.
        opcion = Interfaz.pedirOpcion();
        // Operar con la opcion seleccionada.
    	// ------------------------------------------------------------------        
    	try {
        	if ( opcion != 0 ) {
            	// ------------------------------------------------------------------
            	// Cargamos los datos de entrada al programa
            	System.out.println("Cargando los datos de entrada ... ");
            	Interfaz.animacion();
            	// ------------------------------------------------------------------
        		dEntrada = Datos.dataEntry();
        	}
            switch (opcion) {
            	case 1 -> opcion1(dEntrada); // kevin()
            	case 0 -> salir();
            	default -> opcionNoExiste();
            }
        } catch( Exception e) {
        	System.out.println("Error: " + e);
        	System.out.println();
        	String sDirectorioTrabajo = System.getProperty("user.dir");
        	System.out.println("El directorio de trabajo es " + sDirectorioTrabajo);
        	System.exit(1);
        }        
    }
    /**
     * opcion1
     * Metodo para calculkar las inversiones encontradas en el fichero de datos. Necesita como parametro los datos de tipo array.
     * @param d
     */
	private static void opcion1(int[] d) {    	
		a = Interfaz.tiempoEjecucion();
    	int ini=0;
    	int fin=d.length-1;    	
    	long resultado = Dominio.mergeSort( d, ini, fin );
    	System.out.println("");
    	System.out.println("");
    	System.out.println("El nº de inversiones encontradas es: " + resultado);
    	System.out.println("");
    	System.out.println("");
    	b = Interfaz.tiempoEjecucion();
        System.out.println();
        System.out.println("Resultado final: "+ (b-a) + "ns");
    }
	/**
	 * salir.
	 * Metodo que finaliza el programa.
	 */
    private static void salir() {
    	Interfaz.finPrograma();    
	}
    /**
     * opcionNoExiste.
     * Controla el mensaje de opcion inexistente.
     */
    private static void opcionNoExiste() {
    	Interfaz.opcionNoExiste();    
	}
	
}
