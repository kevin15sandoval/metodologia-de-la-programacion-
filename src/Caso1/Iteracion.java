package Caso1;
/**
 * Aplicacion del metodo iterativo.
 * 
 * 		Se crea una variable "acumulador" que almacena la suma sucesiva del sumatorio.
 * 		Se crea una variable "resultado" que almacena el valor final del sumatorio.
 * 
 * 		El for itera las veces necesarias, sustituyendo el valor de acumulador.
 * 		Al finalizar, el valor de acumulador se asigna a la variable "resultado".
 * 
 * @author German P.
 */

public class Iteracion {
	public static double iteracion(int valorEntrada) {

        int acumulador = 0;	//Acumula los resultados del sumatorio
        double resultado = 0;		//Contendra el resultado final

        for (int i = 0 ; i <= (valorEntrada-1); i++) {
            acumulador += (4 * i) + 1;
        }

        resultado = acumulador;

        System.out.printf("El numero hexagonal con indice %d es ", valorEntrada, resultado);
        return resultado;
	}
}
