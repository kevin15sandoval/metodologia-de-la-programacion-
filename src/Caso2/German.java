package Caso2;

/**
 * Aplicacion del algoritmo mergesort a un array cualquiera desordenado.
 * 
 * La funcion mergesort devuelve un long con el numero de inversiones.
 * 
 * @author German P.
 *
 * @version 0.2
 */

public class German{
    
    public static long mergesort (int[] array){

        int inputLength = array.length;

        // If the array have less than 2 elements, it will be ordered
        if (inputLength <2){
            return 0;
        }

        // It obtains the median of the array
        int midIndex = array.length / 2;

        // It creates the two empty sub-arrays
        int[] leftHalf = new int [midIndex]; // From 0 to mid
        int[] rightHalf = new int [inputLength - midIndex]; // From midIndex+1 to inputLength

        // It fills the leftHalf array from the original one
        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = array[i];
        }

        // It fills the rightHalf array from the original one
        for (int i = midIndex; i < array.length; i++) {
            rightHalf[i-midIndex] = array[i];   // "i-midIndex" because if i put "i" it starts in midIndex (in the new array)
        }        
        
        return mergesort(leftHalf) + mergesort(rightHalf) + merge(array, leftHalf, rightHalf);
    }

    private static long merge (int[] array, int[] leftHalf, int[] rightHalf){

        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0;  // "i" will run through the leftHalf
        int j = 0;  // "j" will run through the rightHalf
        int k = 0;  // "k" will run throught the merged array (final array)

        long inversionsNum = 0;

        while (i < leftSize && j < rightSize) {  // It loops until we run out of elements in one of the two arrays
            if (leftHalf[i] <= rightHalf[j]) {  // If element in leftHalf is smaller, we put it on the merged array
                array[k] = leftHalf[i];
                i++;
            }
            else {  // Otherwise, we put the element of rightHalf on the merged array
                array[k] = rightHalf[j];
                inversionsNum += leftSize -i;
                j++;
            }
            k++;
        }

        // At this point, maybe one of the arrays could have "unrevised elements" because of an odd initial array (I think)
        // These two loops adds to the merged array the remaining items
        while (i < leftSize) {
            array[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = rightHalf[j];
            j++;
            k++;
        }

        return inversionsNum;
    }
}