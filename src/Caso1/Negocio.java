package Caso1;

/**
 * <h1>Caso de estudio 1</h1>
 * 
 * Se necesitan calcular los numeros hexagonales, Los primeros números hexagonales son:
 * 		1, 6, 15, 28, 45, 66, 91, 120, 153, 190, 231, 276, 325, 378, 435, 496, 561, 630, 703, 780, 861, 946
 * Para ello se realizará su búsqueda de tres formas distintas, mediante:
 * 	- La aplicación directa de la fórmula.
 * 	- La aplicación del método recursivo.
 * 	- La aplicación del método iterativo.
 *
 * @author Paulino
 * @version 0.1
 *
 */

public class Negocio {
	public void negocio() {
		int valorEntrada =0;
		FormulaDirecta.formulaDirecta(valorEntrada);
		Iteracion.iteracion(valorEntrada);
		Recursivo.recursivo(valorEntrada);
	}
}
