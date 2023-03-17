package Caso2;

import java.util.Arrays;

public class German{
    
    public static int mergesort (int[] datos, int inicio, int finD){

        //Crea una copia de "d", con el tamanio de "d"
        int [] copia = Arrays.copyOf(datos, datos.length);

        // Caso Base
        if (finD <= inicio){
            return 0;
        }

        int mitad = ( inicio + ((finD - inicio ) >> 1 ));

        int numInversiones = 0;

        // Va dividiendo mitad izquierda
        numInversiones += mergesort(datos, inicio, mitad);

        // Va dividiendo mitad derecha
        numInversiones += mergesort(datos, mitad+1, finD);

        // Union de las dos mitades
        numInversiones += merge(datos, copia, inicio, mitad, finD);

        return numInversiones;
    }

    public static int merge (int [] d, int [] copia, int min, int mid, int max){
        
        int inicio = min;
        int i = min;
        int mitad = mid + 1;
        int fin = max;

        int numInversiones = 0;

        //Mientras haya algo en el array, continuo
        while (inicio <= mid && mid <= fin) {
            if (d [inicio] <= d [mitad]) {
                copia [i++] = d [inicio++]; 
                
            } else {
                copia [i++] = d [inicio++];
                numInversiones += (mid - inicio + 1);
            }
        }

        // Se copian los elementos restantes que ya vienen ordenados en el array
        while (inicio <= mid) {
            copia [i++] = d [inicio++];
        }

        // No hay que copiar la segunda mitad, los numeros restantes estan bien colocados en "copia".
        // Se copia al array original

        for (inicio = min; inicio <= max; inicio++) {
            d [inicio] = copia [inicio];
        }
    
        return numInversiones;
    }
}
