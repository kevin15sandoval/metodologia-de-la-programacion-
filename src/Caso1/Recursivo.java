package Caso1;
/**
 * <h1>Aplicación del método recursivo.</h1>ç
 * @author Kevin A.
 * paso: 1: establecemos el caso base que sera cuando el valor de la entrada es 1, por lo que el return sera 1 ya que es el caso base 
 * paso 2: estabelcemos el metrodo recursivo aplicando la formula del metodo iteratico el cuañl es 4*n+1 y luego hacemos la recursividad llamando
 * al metodo nuevamente y restandole uno para asi llegar nuevamnete el caso base y nos el valor correspondiente del numero hexagonal.
 */
public class Recursivo {
	
	public static int recursivo(int valorEntrada) {
		 //caso base   
		if (valorEntrada == 1) {
		        return 1;
		    }
		 //caso recursivo    
		 return  recursivo(valorEntrada - 1) + 4 *valorEntrada - 3 ;
	}
	
}
