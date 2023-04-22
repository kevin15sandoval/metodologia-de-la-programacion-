package subC_Pau;

import java.util.ArrayList;
import java.util.Arrays;


public class CrearColaBaldosas {

    /**
     * CrearColaBaldosas.
     * Metodo que nos genera un arraylist ordenado de mayor a menor, con los valores pasados por un array de tipo Integer.
     * @param tamaniosBaldosas
     * @return colaBaldosas 
     */
    public static ArrayList<Integer> crearColaBaldosas(int[] tamaniosBaldosas) {
        ArrayList<Integer> colaBaldosas = new ArrayList<Integer>();
        System.out.println(tamaniosBaldosas);
        // ArrayList con la cola de las baldosas de tamaño = tamaniosBaldosas
        /*for (int i = 0; i < tamaniosBaldosas.length; i++) { colaBaldosas.add(tamaniosBaldosas[i]); }
        // Ordenamos de mayor a menor los valores de tamaniosBaldosas
        Collections.sort(colaBaldosas, Collections.reverseOrder());*/
        return colaBaldosas;
    }
}





/*


-----------------------------------------------------


int ladoFinca = 9;
int[][] finca = new int[ladoFinca][ladoFinca];
int posicionActual = 0;
Cultivo[] cultivos = {
		new Cultivo (2),
		new Cultivo (10),
		new Cultivo (5),
		new Cultivo (3)
		
};

// Ordenamos de mayor a menor
Arrays.sort(cultivos);
// Recorremos el array y lo pasado al metodo de distribucion de 
for (Cultivo cultivando : cultivos) {
	distribuirCultivos(finca, cultivando.getTam(),cultivando.getTam());        
}
// Imprimir el cuadrado inicial
for	( int i = 0; i < ladoFinca; i++) {
	for ( int j = 0; j < ladoFinca; j++ ) {
		System.out.print(" *");
	}
	System.out.println();
}
System.out.println("\n________________________________________________________________________\n");

// Imprimir resultado
for (int i = 0; i < ladoFinca; i++) {
    for (int j = 0; j < ladoFinca; j++) {
    	// Verifica el valor de la posicion i,j en la matriz. 
    	// 1) Si el valor es 0 entonces imprime '*' --> seccion vacía
    	// 2) Si es diferente imprime el valor asignado
        System.out.print(finca[i][j] == cultivos ? " L" : " O");
    }
    System.out.println();
}

*/