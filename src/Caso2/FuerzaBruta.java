package Caso2;

public class FuerzaBruta {

	public static int fuerzaBruta(int[] datosEntrada) {
		int inversionContada = 0;
		
		for ( int i = 0; i < datosEntrada.length - 1 ; i++) {
			for ( int j = i+1 ; j < datosEntrada.length; j++ ) {
				if ( datosEntrada[i] > datosEntrada[j] ) {
					inversionContada++;
				}
			}
		}
		return inversionContada;
	}

}
