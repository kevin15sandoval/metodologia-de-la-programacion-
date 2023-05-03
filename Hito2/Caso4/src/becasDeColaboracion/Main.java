package becasDeColaboracion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	/**
	 * Main.
	 * @param args
	 */
    public static void main(String[] args) {
    	/* Fichero de entrada */
    	final String ArchivoBecas = "BECAS.dat";
    	/* Lectura del fichero */
    	List<Beca> becas = new ArrayList<>(); // Lista con los datos leídos    
    	// Leemos
    	becas = leerFichero(ArchivoBecas);
    	// Planificamos las becas
        PlanificadorBecas planificador = new PlanificadorBecas(becas);
        List<Beca> solucion = planificador.getSolucion();
        // Calculamos sueldo total anual y por beca
        int sueldoTotal = 0;
        System.out.println("La combinacion de becas con mayor beneficio es el siguiente: ");
        for (int i = 0; i < solucion.size(); i++) {
        	int sueldo = solucion.get(i).getSalario()*(solucion.get(i).getMesFin()-solucion.get(i).getMesInicio());
            System.out.println(solucion.get(i).toString());
            System.out.println( sueldo + " Euros");
            
            sueldoTotal += sueldo;
        }
        System.out.println("\n Beneficio total a percibir: " + sueldoTotal + " euros");
     
    }
    /**
     * Metodo de lectura del fichero.
     * @param nombreArchivo
     * @return listaBecas
     */
    public static List<Beca> leerFichero(String nombreArchivo) {    	
    	List<Beca> listaBecas = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;            
			int tamanioLista = Integer.parseInt(br.readLine()); // Leemos la primera línea como tamaño de la lista
			int contadorLineas = 0;			
            if (tamanioLista > 0 ) { 
	            while ((linea = br.readLine()) != null) {
	                String[] campos = linea.split("\t"); // Separamos los campos por el caracter de tabulación
	                int id = Integer.parseInt(campos[0]);
	                int inicio = Integer.parseInt(campos[1]);
	                int fin = Integer.parseInt(campos[2]);
	                int monto = Integer.parseInt(campos[3]);
	                // El intervalo de las becas no está dentro de los 12 meses
	                if (( inicio > 0 && inicio < 12) && (fin > 0 && fin <= 12 )) {
	                	try {
		                	Beca beca = new Beca(id, inicio, fin, monto); // Creamos un objeto Beca con los campos correspondientes
			                listaBecas.add(beca); // Añadimos la beca a la lista
			                contadorLineas++;		                
		                } catch  (NumberFormatException e) {
		                	MiException.exSrtring();
		                	System.out.println(e);
		                	System.exit(0);
		                }
	                } else if ( inicio == fin ) {
	                	System.out.println("El mes de inicio coincide con el mis de fin");
	                	System.out.println("Revise el fichero de datos de entrada.");
	                	System.exit(0);
	            	} else {
	                	System.out.println("El numero de meses no esta en el intervalo 1-12.");
	                	System.out.println("Revise el fichero de datos de entrada.");
	                	System.exit(0);
	                }
	            }
            } else {
            	MiException.exNumNegativo();
            	System.exit(0);
            }
            br.close();
            // Buscamos el nº de  lineas existente frente al encontrado.
            if ( contadorLineas != tamanioLista ) {
            	MiException.exTotalLines();
            	System.exit(0);
            }
    	} catch (ArrayIndexOutOfBoundsException fIndex) {
    		MiException.ArrayIndexOutOfBounds();
        	System.out.println(fIndex);
        	System.exit(0);
    	}catch (NumberFormatException ex) {
    		MiException.exSrtring();
        	System.out.println(ex);
        	System.exit(0);
    	}catch (IOException e) {
    		System.out.println("Error al leer el fichero  " + e.getMessage());    		
        	System.exit(0);
    	}
    	return listaBecas;
    }
}

/* **********************************************************************
 * 
 * #####~##~~##~~####~~#####~#####~~######~######~~####~~##~~##~~####~
 * ##~~~~~####~~##~~##~##~~~~##~~##~~~##~~~~~##~~~##~~##~###~##~##~~~~
 * ####~~~~##~~~##~~~~~####~~#####~~~~##~~~~~##~~~##~~##~##~###~~####~
 * ##~~~~~####~~##~~##~##~~~~##~~~~~~~##~~~~~##~~~##~~##~##~~##~~~~~##
 * #####~##~~##~~####~~#####~##~~~~~~~##~~~######~~####~~##~~##~~####~
 * 
 * **********************************************************************
 */

class MiException extends Exception {
	/**
	 * Implementacion de interfaz serializable. Las clases que implementan este interfaz son susceptibles de ser serializables (guardadas en disco)
	 * Los atributos del objeto se convierten en cadenas de bytes y se guardan en el disco. Para leer un objeto, se leen las cadenas de bytes y se reconstruye
	 * el objeto a partir de ellos.
	 * @see Source: https://howtodoinjava.com/java/serialization/serialversionuid/
	 */
	private static final long serialVersionUID = 1L;	
	/**
	 * Mensaje de control de numeros negativos
	 */
	static void exNumNegativo() {
		System.out.print("""
				===================================================== \n
				\t\t WARNING!!! \n 
				Tamanio de becas invalida. \n
				El numero introducido es cero o negativo. \n
				Por favor, verifique el fichero DATOS.dat Y reinicie la ejecucion del programa
				===================================================== \n
				""");
	}
	/**
	 * Mensaje que se ejecuta cuando falta algun dato en el fichero
	 */
	public static void ArrayIndexOutOfBounds() {
		System.out.print("""
				===================================================== \n
				\t\t WARNING!!! \n 
				Entrada invalida. \n
				Se ha encontrado una fallo en el fichero de entrada. \n
				Revise los datos de entrada y vuelva a intentarlo de nuevo. \n
				===================================================== \n
				""");
		
	}
	/**
	 * Mensaje de control de String o floats introducidos 
	 */
	public static void exSrtring() {
		System.out.print("""
				===================================================== \n
				\t\t WARNING!!! \n 
				Medida invalida. \n
				Ha introducido un dato incoherente, debe introducir solo numeros enteros. \n
				Revise los datos del fichero y vuelva a intentarlo de nuevo. \n
				===================================================== \n
				""");		
	}
	/**
	 * Mensaje de control de numero de lineas introducido frente a los leídos en el fichero 
	 */
	public static void exTotalLines() {
		System.out.print("""
				===================================================== \n
				\t\t WARNING!!! \n 
				No coinciden el numero de lineas. \n
				El nº lineas encontrado en el fichero VS nº el introducido en el fichero. \n
				no coinciden. \n
				REVISE EL FICHERO Y VUELVA A INTENTARLO DE NUEVO.
				===================================================== \n
				""");		
	}
}
