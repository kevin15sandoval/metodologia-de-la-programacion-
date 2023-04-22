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
	public static void main(String[] args) throws InterruptedException {
		bienvenida(); // OK
		int superficie = datosSuperficie(); // OK 
		int cantBaldosas = cantBaldosas();
		int[] listadoBaldosas = crearColaBaldosas(cantBaldosas);
		Dominio.dominio(superficie, listadoBaldosas);		
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
	 * @throws InterruptedException 
	 */
	private static void bienvenida() throws InterruptedException {
		System.out.print("""
				\n				
				\t\t =============================================================== \n
				\t\t BIENVENIDO AL SOLADO ECONOMICO DE LOS HERMANOS SCOOT. \n
				\t\t =============================================================== \n
				\t\t El programa busca la cantidad mínima de baldosas necesarias para cubrir una superficie cuadrada. \n 
				\t\t Para que funcione correctamnete, es necesario que proporciones: \n 
				\t\t\t  1- Medidas de la superficie. \n 
				\t\t\t  2- Tamaño de las baldosas. \n
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
				\t Tamanio del lado de la superficie del solar: 
				""");
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
	 * Menu con la cantidad de baldosas disponibles.
	 * 
	 * Metodo que solicita al usuario la cantidad de baldosas que quiere dar de alta.
	 * @return cantidad
	 */
	private static int cantBaldosas() {
		System.out.print("""
				\n CANTIDAD DE BALDOSAS. \n
				\t Introduzca la cantidad de baldosas que quiere dar de alta: \n
				""");
		int cantidad = sc.nextInt();				
		return cantidad;
	}
	/**
	 * Menu con el listado del lado de la baldosa
	 * 
	 * Metodo que guarda los tipos de baldosas cuadradas disponibles a partir del lado, proporcionado por el usuario. 
	 * @return lbaldosas
	 */
	private static int[] datosBaldosa() {
		System.out.print("""
				\n DATOS DE LAS BALDOSAS. \n		
				\t Escriba el lado de las baldosas: \n
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
	 * Metodo que solicita al usuario el valor de los lados de las baldosas que usará el sistema.
	 * @param cantidad
	 * @return lista
	 */
	private static int[] crearColaBaldosas(int cantidad) {
		int[] lista = new int[cantidad];
		int input = 0;
		System.out.println("\n ALTA BALDOSAS. \n");
		for ( int i = 0; i < lista.length; i++) {
			System.out.printf("Introduzca el lado para la baldosa nº %d ",i);
			sc = new Scanner(System.in);
			input = sc.nextInt();
			lista[i] = input;
		}
		
		return lista;
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
				El numero introducido es cero. El programa no puede procesarlo. \n
				===================================================== \n
				""");		
	}
}
