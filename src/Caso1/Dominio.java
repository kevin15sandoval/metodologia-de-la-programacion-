package Caso1;


public class Dominio {
	/**
	 * Aplicacion de la formula directa.
	 * 
	 */
	/*
	 * @author Andres D.
	 *
	 */
	public static double formulaDirecta(int valorEntrada) {
		double calculo = valorEntrada*(2*valorEntrada-1); //se calcula el valor de calculo utilizando el valor de valorEntrada
		return calculo; //se retorna el valor de calculo
	}
	/**
	 * Aplicacion del metodo iterativo.
	 * 
	 * 		Se crea una variable "acumulador" que almacena la suma sucesiva del sumatorio.
	 * 		Se crea una variable "resultado" que almacena el valor final del sumatorio.
	 * 
	 * 		El for itera las veces necesarias, sustituyendo el valor de acumulador.
	 * 		Al finalizar, el valor de acumulador se asigna a la variable "resultado".
	 *
	 * 
	 */
	
	/*
	 * @author German P.
	 */
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
	/**
	 * {@docRoot}
	 * Aplicacion del metodo recursivo.
	 * 
	 * paso: 1:
	 *  	Establecemos el caso base que sera cuando el valor de la entrada es 1, por lo que el return sera 1 ya que es el caso base	
	 *  
	 * paso 2: 
	 * 		Estabelcemos el metrodo recursivo aplicando la formula H(n-1) + 4n-3 y siendo el H(N-1) Lo que aplicamos en la recursividad 
	 * 		llamando de nuevo a nuestro metodo con el valor restando uno para llegar hatsa el caso base, y posteriormente colocamos la continucacion
	 * 		de la formula a la que llegamos en nuestro algoritmo obteniendo asi nuestro valores de los numeros hexagonales correspondientes
	 */
	/*
	 * @author Kevin A.
	 */	
	public static double recursivo(int valorEntrada) {
		 //caso base   
		if (valorEntrada == 1) {  		
	        return 1;
	    } else {
			//caso recursivo    
			return  recursivo(valorEntrada - 1) + 4 *valorEntrada - 3 ;
	    }	
	}
}
