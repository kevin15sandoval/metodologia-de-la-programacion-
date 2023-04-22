package subC_Pau;

import java.util.ArrayList;

public class SeleccionarBaldosa {

    /**
     * SeleccionarBaldosa.
     * Pasado como parametro el arraylist con la cola de las baldosas
     * @param colaBaldosas
     * @param areaRestante
     * @return colaBaldosa.posicion
     */
    public static int seleccionarBaldosa(ArrayList<Integer> colaBaldosas, int areaRestante) {
    	System.out.println(colaBaldosas);
        /*for (int i = colaBaldosas.size() ; i >= 0; i--) {
            if (colaBaldosas.get(i) <= areaRestante) {
                return colaBaldosas.get(i);
            }
        }*/
        return 0; // En caso de error
    }

}
