package Caso2;

import java.lang.reflect.Array;
import java.util.Scanner;

public class kevin {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	      System.out.print("Ingrese el tamanoa�o del array: ");
	      int tamano = sc.nextInt();
	      
	      int[] numeros = new int[tamano];
	      
	      for (int i = 0; i < tamano; i++) {
	         System.out.print("Ingrese el valor para la posici�n " + i + ": ");
	         numeros[i] = sc.nextInt();
	      }
	      long inversiones = mergeSort(numeros,0,numeros.length-1);
	      System.out.println("Hay un total de " + inversiones + " inversiones en este array");
	}
	
	/*
	     *  Es la funci�n de "divisi�n" que divide el array en dos mitades y 
	     * llama recursivamente a mergeSort en ambas mitades hasta que el tamanoa�o de la mitad es uno.
	     */
	    private static long mergeSort(int[] array,  int izquierda, int derecha) {
	    	//creamos un array temporal que luego nos ayudara para ordenar el array original por ello su tma�ano es igual al del array
	    	int[] temporal = new int[array.length];
	       //Inicializamos el contador a 0 porque este nos llevara la cuenta del numeor de inversores en nuetsro array
	    	long contador = 0;
	    	//
	        if (izquierda < derecha) {
	            int mitad = (izquierda + derecha) / 2;
	            contador += mergeSort(array, izquierda, mitad);
	            contador += mergeSort(array, mitad + 1, derecha);
	            contador += merge(array, temporal, izquierda, mitad, derecha);
	        }
	        return contador;
	    }
	    /*
	     * La funci�n merge es la funci�n de "mezcla" que mezcla las dos mitades y cuenta el n�mero de inversiones en el proceso.
	     */
	    private static long merge(int[] array, int[] temporal, int izquierda, int mitad, int derecha) {
	        long contador = 0;
	        int i = izquierda, j = mitad + 1, k = izquierda;
	        while (i <= mitad && j <= derecha) {
	            if (array[i] <= array[j]) {
	                temporal[k++] = array[i++];
	            } else {
	                temporal[k++] = array[j++];
	                contador += mitad - i + 1; // Contabiliza las inversiones
	            }
	        }
	        while (i <= mitad) {
	            temporal[k++] = array[i++];
	        }
	        while (j <= derecha) {
	            temporal[k++] = array[j++];
	        }
	        for (i = izquierda; i <= derecha; i++) {
	            array[i] = temporal[i];
	        }
	        
	        return contador;
	    }

}
