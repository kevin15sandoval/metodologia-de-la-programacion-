package Caso1;
/**
 * <h1>Aplicacion de la formula directa.</h1>
 * <p>
 * 		
 * </p>
 * @author Andres D.
 *
 */
import java.util.Locale;
import java.util.Scanner;

public class FormulaDirecta {
	
	public static double formulaDirecta(int valorEntrada) {
		double calculo = valorEntrada*(2*valorEntrada-1); //se calcula el valor de calculo utilizando el valor de valorEntrada
		return calculo; //se retorna el valor de calculo
	}
}
