package Caso1;
/**
 * <h1>Aplicacion de la formula directa.</h1>
 *
 * @author Andres D.
 *
 */
import java.util.Locale;
import java.util.Scanner;

public class FormulaDirecta {
	
	public static int formulaDirecta(int valorEntrada) {
		System.out.println("Dentro de la opcion de formula directa"); //se escribe este texto por pantalla
		int calculo = valorEntrada*(2*valorEntrada-1); //se calcula el valor de calculo utilizando el valor de valorEntrada
		return calculo; //se retorna el valor de calculo
	}
}
