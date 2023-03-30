package Caso2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Practicas. Caso de estudio 2.
 * 
 * Descripción del problema.
 * 	Algunos sitios Web hacen uso de una técnica conocida como filtrado colaborativo.
 * 	Con ella, estos sitios intentan hacer concordar nuestras preferencias con las de otros usuarios. Una vez que el sitio Web ha identificado individuos con preferencias similares a
 * 	las nuestras -basándose en la comparación de cómo los usuarios hemos puntuado o calificado determinados productos- puede recomendarnos nuevos productos que los otros
 * 	usuarios hayan apreciado. Por ejemplo, un sitio de música puede intentar emparejar nuestras preferencias musicales con las de otros usuarios de la forma siguiente:
 * 		• Nosotros clasificamos n canciones
 * 		• El sitio Web consulta su base de datos para encontrar usuarios con gustos similares
 * 	El punto principal en una aplicación como esta es el problema de cómo comparar dos clasificaciones (rankings). Es decir, ¿cómo se determina la semejanza de dos rankings?
 * 	Un método directo sería clasificar n canciones (o el producto del que se trate) de 1 a n en función de nuestras preferencias. Ahora, comparamos con la otra clasificación
 * 	determinando cuantas parejas están descolocadas. Por ejemplo, en el caso de las canciones:
 * 		- Nuestra clasificación (la referencia): 1, 2, …, n
 * 		- Otra clasificación: a1, a2, …, an
 * 		- Las canciones i and j están invertidas (descolocadas) si i < j, pero ai > aj
 * 	Por tanto ver el ejemplo siguiente:
 * 		@see<a href="https://campusvirtual.uclm.es/pluginfile.php/5769295/mod_resource/content/28/CasoEstudio2_MP_2022_23.pdf" target="_blank" rel="noopener noreferrer">Recuento de inversion de un array - Explicacion completa del problema.</a> <br>
 * 	Problema.
 *  	  Dada una permutación contar el número de inversiones. <br>
 * @author Paulino Bermudez
 * @version 0.1
 */
public class Main {
	private static double a = 0;
	private static double b = 0;
	/**
	 * Metodo principal.- Inicio del programa.
	 */
    public static void main(String[] args) {
        do {
        	inicioPrograma();
        }while(true);
        	
    }
    /**
     * inicioPrograma.
     * inicio del programa junto con los datos de entrada
     */
    public static void inicioPrograma() {

    	// Variables necesarias para interactuar con el usuario
    	int[] dEntrada = null;
    	int opcion = 0;
    	
    	// ------------------------------------------------------------------
    	// Mensaje de bienvenida.
        bienvenida();
        // Selecciónar opcion del programa.
        opcion = pedirOpcion();
        // Operar con la opcion seleccionada.
    	// ------------------------------------------------------------------        
    	try {
        	if ( opcion != 0 ) {
            	// ------------------------------------------------------------------
            	// Cargamos los datos de entrada al programa
            	System.out.println("Cargando los datos de entrada ... ");
            	animacion();
            	// ------------------------------------------------------------------
        		dEntrada = dataEntry();
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
		a = tiempoEjecucion();
    	int ini=0;
    	int fin=d.length-1;    	
    	long resultado = Dominio.mergeSort( d, ini, fin );
    	System.out.println("");
    	System.out.println("");
    	System.out.println("El nº de inversiones encontradas es: " + resultado);
    	System.out.println("");
    	System.out.println("");
    	b = tiempoEjecucion();
        System.out.println();
        System.out.println("Resultado final: "+ (b-a) + "ns");
    }
	/**
	 * salir.
	 * Metodo que finaliza el programa.
	 */
    private static void salir() {
    	finPrograma();    
	}
    /**
     * opcionNoExiste.
     * Controla el mensaje de opcion inexistente.
     */

	private static void opcionNoExiste() {
		System.out.println();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! WARNING !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.printf(" \t %s La opcion que escribiste, no existe, vuelve a intentarlo de nuevo \n",usuario);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Main.inicioPrograma();		
	}
    public static int[] dataEntry() {
    	// Fichero de entrada
    	File file = new File(FICHERO_DATOS);
    	// Scanner de datos
    	Scanner sc = null;
    	
    	try {
    		sc = new Scanner(file);
    	} catch (FileNotFoundException e) {
    		System.out.println("Revise el nombre del fichero en java");
    		e.printStackTrace();
    	}
    	// Leemos el primer renglon y declaramos el tamaño del array que queremos.
    	int size = sc.nextInt();
    	// Creamos el array con el tamaño detectado
    	int[] arrayDatos = new int[size];
    	// Rellenamos el array
    	for	( int i = 0; i < size; i++ ) {
    		arrayDatos[i] = sc.nextInt(); 
    	}
    	sc.close();
    	// System.out.println(Arrays.toString(arrayDatos)); // Imprimimos los datos leídos
    	return arrayDatos;
    }
    
    static // -------------------------------- METODOS DE LA INTERFAZ ---------------------------------
    

	String usuario = System.getProperty("user.name");
	// Fichero con los datos de entrada	
	public static String FICHERO_DATOS = "src/Caso2/Data/InversionsHito1.dat";
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
		System.out.println("1- Calcular inversiones en los datos proporcionados.");
		System.out.println("____________________________________________________");
        System.out.println("0- Finalizar programa.");
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
		String anim= "|====>"; for (int x =0 ; x < 11 ; x++) { 
			String data = "\t" + anim.charAt(x % anim.length()) + " " + x ; System.out.write(data.getBytes()); Thread.sleep(100);		
		}
		System.out.println();
	}
}
