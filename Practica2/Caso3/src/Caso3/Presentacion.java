package Caso3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Solado eco.
 * Necesitamos solar una superficie cuadrada de n metros de lado.
 * A tal efecto,contratamos a los hermanos Scott,unos instaladores reformistas con amplia experiencia,para realizar el trabajo.
 * Para el solado podemos elegir diferentes baldosas cuadradas de s0,s1,s2,� metros de lado. <br>
 * Gracias a sus contactos profesionales, los hermanos Scott pueden conseguir las baldosas al mismo precio por baldosa independientemente del tamano. 
 * Ademas, pueden conseguir la cantidad necesaria de baldosas de cualquier tamano. Para reducir costes, pretendemos utilizar tan pocas baldosas como sea posible 
 * y por razones esteticas queremos usar baldosas enteras (aunque se mezclen tamanios).
 * @author paulino
 * @version 0.1
 *
 */
public class Presentacion {
	
	/*
	 * ##~~~#~~####~~######~##~~##
	 * ###~##~##~~##~~~##~~~###~##
	 * ##~#~#~######~~~##~~~##~###
	 * ##~~~#~##~~##~~~##~~~##~~##
	 * ##~~~#~##~~##~######~##~~##
	 * 
	 */
	public static void main(String[] args) throws InterruptedException {
		bienvenida(); // OK
		int superficie = datosSuperficie(); // OK 	
		
		List<Integer> cola = null;
		int[] n = datosBaldosa(); // OK		
		cola = crearColaBaldosas(n);
		System.out.println(cola);
		
		List<Integer> baldosasUsadas = cubrirSuperficie(superficie, cola);
		System.out.println(baldosasUsadas.size());		
	}
	
	public static Scanner sc;	
	/*
	 * ##~~~#~#####~##~~##~##~~##
	 * ###~##~##~~~~###~##~##~~##
	 * ##~#~#~####~~##~###~##~~##
	 * ##~~~#~##~~~~##~~##~##~~##
	 * ##~~~#~#####~##~~##~~####~
	 */
	/**
	 * Metodo para el mensaje de Bienvenida
	 * 
	 * Imprime el mensaje de bienvenida de plataformado de un suelo a partir de baldosas cuadradas.
	 * El programa busca la cantidad minima de baldosas necesarias para cubrir la superficie proporcionada por el usuario.
	 * @throws InterruptedException 
	 */
	private static void bienvenida() throws InterruptedException {
		System.out.print("""
				\n				
				\t\t =============================================================== \n
				\t\t BIENVENIDO AL SOLADO ECONOMICO DE LOS HERMANOS SCOOT. \n
				\t\t =============================================================== \n
				\t\t El programa busca la cantidad minima de baldosas necesarias para cubrir una superficie cuadrada. \n 
				\t\t Para que funcione correctamnete, es necesario que proporciones: \n 
				\t\t\t  1- Medidas de la superficie. \n 
				\t\t\t  2- Tamanio de las baldosas. \n
				""");
		Thread.sleep(3000);
	}
	/**
	 * Metodo menu de datos de superficie.
	 * 
	 * Proporciona la superficie total a cubrir con las baldosas.
	 * @return superficie
	 */
	private static int datosSuperficie() {		
		int superficie = 0;
		System.out.print("""
				\n DATOS DE SUPERFICIE.  \n
				\t Introduce el tamanio de la superficie a solar: """);
		sc = new Scanner(System.in);
		superficie = sc.nextInt();
		if ( superficie < 0 ) {
			MiException.exNumNegativo();
			datosSuperficie();
		} else if ( superficie == 0) {
			MiException.exNumZero();
			datosSuperficie();
		}		
		return superficie;				
	}
	/**
	 * Menu con el lado de la baldosa
	 * 
	 * Metodo que guarda los tipos de baldosas cuadradas disponibles a partir del lado, proporcionado por el usuario. 
	 * @return lbaldosas
	 */
	private static int[] datosBaldosa() {
		System.out.print("""
				\n DATOS DE LAS BALDOSAS. \n		
				\t Escriba el lado de las baldosas, separados por comas: \n
					""");
		String datos = sc.nextLine();
		String[] ladosString = datos.split(",");
		int[] lados = new int[ladosString.length];
		for (int i = 0; i < ladosString.length; i++) {
			lados[i] = Integer.parseInt(ladosString[i]);
		}			
		return lados;
	}	
	/**
	 * Metodo crearColaBaldosas.
	 * 
	 * Crea una cola que contenga los valores de las areas de todas las posibles baldosas que se pueden formar con ese tamanio de lado.
	 * Se usa un bucle y calcula el valor de 'j' en cada iteracion, reduciendo la cantidad de iteraciones. Ademas, usa un conjunto HastSet 
	 * llamado 'areas' para mantener un registro de las areas que ya se han agregado, reduciendo la cantidad de operaciones de busqueda en 
	 * la cola. 
	 * Finalmente, la cola se define como una PriorityQueue, lo que elimina la necesidad de ordenar los elementos despues.
	 * @param lado
	 * @return cola
	 */
	private static List<Integer> crearColaBaldosas(int[] ladoDado) {
		List<Integer> cola = new ArrayList<>();
		Set<Integer> areas = new HashSet<>();
        for (int lado : ladoDado) {
    		int area = lado * lado;
    		if ( !areas.contains(area)) {
    			cola.add(area);
    			areas.add(area);
    		}
        }
        Collections.sort(cola);
        return cola;
	}
	/**
	 * Metodo cubrirSuperficie
	 * 
	 * Metodo de calculo para la resolucion del numero de baldosas utilizadas para cubrir la superficie dada.
	 * @param superficie
	 * @param cola
	 * @return bUsadas
	 */
	private static List<Integer> cubrirSuperficie(int superficie, List<Integer> cola) {		
		List<Integer> bUsadas = new ArrayList<>();
		while ( superficie > 0 ) {
			int i = cola.size() - 1 ;
			while ( i >= 0 && cola.get(i) > superficie  ) {
				i--;
			}
			if ( i >= 0 ) {
				int baldosa = cola.get(i);
				bUsadas.add(baldosa);
				superficie -= baldosa;				
			} else {
				System.out.println("Error. No hay baldosas disponibles que quepan en la superficie restante.");				
			}
		}
		return bUsadas;				
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
	 * Source: https://howtodoinjava.com/java/serialization/serialversionuid/
	 */
	private static final long serialVersionUID = 1L;	
	/**
	 * Mensaje de control de numeros negativos
	 */
	static void exNumNegativo() {
		System.out.print("""
				===================================================== \n
				\t\t WARNING!!! \n 
				Medida invalida. \n
				El numero introducido es negativo. \n
				===================================================== \n
				""");
	}
	/**
	 * Mensaje de control de numero cero 
	 */
	public static void exNumZero() {
		System.out.print("""
				===================================================== \n
				\t\t WARNING!!! \n 
				Medida invalida. \n
				El numero introducido es cero. \n
				===================================================== \n
				""");		
	}
}
