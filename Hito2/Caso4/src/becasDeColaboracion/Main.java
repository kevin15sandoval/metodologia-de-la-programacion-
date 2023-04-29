package becasDeColaboracion;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

	public class Main {
	    public static void main(String[] args) {
	    	/* Fichero de entrada */
	    	final String ArchivoBecas = "BECAS.dat";
	    	/* Lectura del fichero */
	    	List<Beca> becas = leerFichero(ArchivoBecas);
	    	
	    	/*
	    	 List<Beca> becas = new ArrayList<>();
	    	 becas.add(new Beca(1, 4, 300));
	    	becas.add(new Beca(3, 8, 100));
	    	becas.add(new Beca(5, 6, 100));
	    	becas.add(new Beca(6, 12, 200));
	    	becas.add(new Beca(8, 12, 400));
	    	becas.add(new Beca(7, 8, 500));
	    	becas.add(new Beca(1, 12, 200));*/
	    	
/*
	        PlanificadorBecas planificador = new PlanificadorBecas(becas);
	        List<Beca> solucion = planificador.getSolucion();
	        System.out.println("La combinacion de becas con mayor beneficio es el siguiente (ordenadas de mayor a menor): ");
	        for (int i = 0; i < solucion.size(); i++) {
	            System.out.println(solucion.get(i).toString());
	        }
*/	        
	    }
	    /**
	     * Metodo de lectura del fichero.
	     * @param nombreArchivo
	     * @return
	     */
	    public static List<Beca> leerFichero(String nombreArchivo) {
	    	final String FICHEROBECAS = "BECAS.dat";
	    	@SuppressWarnings("unused")
			int idBeca = 0,inicio = 0,fin =0,beneficioMensual = 0;
	    	List<Beca> listaBecas = new ArrayList<>(); // ArrayList para almacenar los datos.
	    	
	    	try {
	    		Scanner scanner = new Scanner(new File(FICHEROBECAS));
	    		int nBecas = scanner.nextInt(); // Nº de becas
	    		while ( scanner.hasNextInt()) {
	    			idBeca = scanner.nextInt();
	    			inicio = scanner.nextInt();
	    			fin = scanner.nextInt();
	    			beneficioMensual = scanner.nextInt();
	    			Beca beca = new Becas(idBeca, inicio, fin, beneficioMensual);
	    			listaBecas.add(beca);
	    		}
	    	} catch (IOException e) {
	    		System.out.println("Error al leer el fichero  " + e.getMessage());
	    	}
	    	return listaBecas;
	    }
	}


/**
 * 
 * import java.util.*;

public class Gimnasio {

    public static void main(String[] args) {
        // Paso 1: Leer el archivo de texto y crear una lista de objetos Becas
        List<Becas> Becases = leerArchivo("archivo.txt");

        // Imprimir la lista de Becases leída del archivo para verificar
        System.out.println("Lista de Becases leída del archivo:");
        for (Becas Becas : Becases) {
            System.out.println(Becas);
        }

        // Paso 2: Calcular el gasto óptimo y mostrarlo por pantalla
        double gastoOptimo = calcularGastoOptimo(Becases, 12);
        System.out.println("El gasto óptimo es: " + gastoOptimo);
    }

    public static List<Becas> leerArchivo(String nombreArchivo) {
        // Implementación de la lectura del archivo de texto
        // y creación de una lista de objetos Becas
    }

    public static double calcularGastoOptimo(List<Becas> Becases, int BecasesPorAno) {
        // Implementación del método de backtracking para calcular el gasto óptimo
    }

    private static double calcularGastoOptimoRec(List<Becas> Becases, int BecasesPorAno, int BecasActual, int BecasesIncluidos, double gastoActual, double gastoOptimo) {
        // Implementación del método recursivo para el algoritmo de backtracking
    }

    private static boolean esSolucion(List<Becas> Becases, int BecasesPorAno, int BecasActual, int BecasesIncluidos) {
        // Implementación de la función para determinar si la solución actual es una solución válida
    }

    private static double calcularGasto(List<Becas> Becases) {
        // Implementación del cálculo del gasto total de una solución
    }

    private static void imprimirSolucion(List<Becas> Becases) {
        // Implementación de la función para imprimir por pantalla la solución encontrada
    }
}

 */

