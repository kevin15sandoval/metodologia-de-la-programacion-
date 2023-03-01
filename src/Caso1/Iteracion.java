package Caso1;
/**
 * <h1>Aplicacion del metodo iterativo.</h1>
 * @author German P.
 *
 */
public class Iteracion {
	public static int iteracion(int valorEntrada) {

        int acumulador = 0;	//Acumula los resultados del sumatorio
        int resultado = 0;		//Contendra el resultado final

        for (int i = 0 ; i <= (valorEntrada-1); i++) {
            acumulador += (4 * i) + 1;
        }

        resultado = acumulador;

        System.out.printf("El numero hexagonal con indice %d es ", valorEntrada, resultado);
        return resultado;
	}
}
