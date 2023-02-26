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
	public static void main(String[] args) {
		Scanner leer = new Scanner (System.in); 
		leer.useLocale(Locale.US);
		int valorEntrada = 0; //se crea la variable "valorEntrada" con un valor de 0 
		int valorFinal; //se crea la variable "valorFinal" sin ningun valor inicialmente
		System.out.print("Introduce un valor: "); //se escribe este texto por pantalla
		valorEntrada = leer.nextInt(); //el valorEntrada toma el valor escrito por teclado
		valorFinal = formulaDirecta(valorEntrada); //el valorFinal toma el valor que se ha creado en formulaDirecta
		System.out.print("El resultado es " + valorFinal); //se escribe este texto por pantalla junto con el valor de valorFinal
	}
	
	public static int formulaDirecta(int valorEntrada) {
		System.out.println("Dentro de la opcion de formula directa"); //se escribe este texto por pantalla
		int calculo = valorEntrada*(2*valorEntrada-1); //se calcula el valor de calculo utilizando el valor de valorEntrada
		return calculo; //se retorna el valor de calculo
	}
}
