package Caso3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Solado eco.
 * Necesitamos solar una superficie cuadrada de n metros de lado.
 * A tal efecto,contratamos a los hermanos Scott,unos instaladores reformistas con amplia experiencia,para realizar el trabajo.
 * Para el solado podemos elegir diferentes baldosas cuadradas de s0,s1,s2,… metros de lado. <br>
 * Gracias a sus contactos profesionales, los hermanos Scott pueden conseguir las baldosas al mismo precio por baldosa independientemente del tamaño. 
 * Además, pueden conseguir la cantidad necesaria de baldosas de cualquier tamaño. Para reducir costes, pretendemos utilizar tan pocas baldosas como sea posible 
 * y por razones estéticas queremos usar baldosas enteras (aunque se mezclen tamaños).
 * @author pauli
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
	public static void main(String[] args) {
		bienvenida();
		datosSuperficie();
		
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
	 * El programa busca la cantidad mínima de baldosas necesarias para cubrir la superficie proporcionada por el usuario.
	 */
	private static void bienvenida() {
		System.out.print("""
				\n				
				\t\t ===================================================== \n
				\t\t BIENVENIDO AL SOLADO ECONOMICO DE LOS HERMANOS SCOOT. \n
				\t\t ===================================================== \n
				\t   El programa busca la cantidad mínima de baldosas necesarias para cubrir una superficie cuadrada. \n 
				\t   Para que funcione correctamnete, es necesario que proporciones: \n 
				\t\t  1- Medidas de la superficie. \n 
				\t\t  2- Tamaño de las baldosas. \n
				\t.............................................. \n
				\t\t Pulse ENTER para continuar
				\t.............................................. \n
				""");		
		sc = new Scanner(System.in); 
	}
	/**
	 * Metodo menu de datos de superficie.
	 * 
	 * Proporciona la superficie total a cubrir con las baldosas.
	 * @return superficie
	 */
	@SuppressWarnings("finally")
	private static int datosSuperficie() {		
		int superficie = 0;
		System.out.print("""
				\n DATOS DE SUPERFICIE.  \n\n 
				\t Introduce el tamaño de la superficie a solar: """);
		sc = new Scanner(System.in);
		superficie = sc.nextInt();
		try {
			if ( superficie < 0 ) {
				MiException.exNumNegativo();
				datosSuperficie();
			} else if ( superficie == 0) {
				MiException.exNumZero();
				datosSuperficie();
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());			
		} finally {
			sc.close();
			return superficie;
		}
	}
	/**
	 * Menu con el lado de la baldosa
	 * 
	 * Metodo que guarda los tipos de baldosas cuadradas disponibles a partir del lado, proporcionado por el usuario. 
	 * @return lbaldosas
	 */
	private static int datosBaldosa() {
		int lBaldosas;
		int [] ladoBaldosas;
		System.out.print("""
				\n DATOS DE LAS BALDOSAS. \n\n		
				\t Tamaño del lado de la baldosa [mts]:
					""");
		sc = new Scanner(System.in);
		lBaldosas = sc.nextInt();
		return lBaldosas;
	}	
	
	private static Queue<Integer> crearColaBaldosas(int lado) {
		Queue<Integer> cola = new LinkedList<>();
        for (int i = 1; i <= lado; i++) {
            for (int j = 1; j <= lado; j++) {
                int area = i * j;
                if (!cola.contains(area)) {
                    cola.offer(area);
                }
            }
        }
        return cola;
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
	 * Implementación de interfaz serializable. Las clases que implementan este interfaz son susceptibles de ser serializables (guardadas en disco)
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
