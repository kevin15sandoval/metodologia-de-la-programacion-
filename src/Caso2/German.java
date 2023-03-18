package Caso2;

public class German{
    
    public static void mergesort (int[] array){
        // I got it to return the sorted array but I don't know how to get the number of inversions by now
        // I am having trouble locating them

        int inputLength = array.length;

        // If the array have less than 2 elementos, it will be ordered
        if (inputLength <2){
            return;
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
        
        //It runs recursively until I have less than two elements on the arrays
        mergesort(leftHalf);
        mergesort(rightHalf);

        merge(array, leftHalf, rightHalf);
    }

    private static void merge (int[] array, int[] leftHalf, int[] rightHalf){

        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0;  // "i" will run through the leftHalf
        int j = 0;  // "j" will run through the rightHalf
        int k = 0;  // "k" will run throught the merged array (final array)

        while (i < leftSize && j < rightSize) {  // It loops until we run out of elements in one of the two arrays
            if (leftHalf[i] <= rightHalf[j]) {  // If element in leftHalf is smaller, we put it on the merged array
                array[k] = leftHalf[i];
                i++;
            }
            else {  // Otherwise, we put the element of rightHalf on the merged array
                array[k] = rightHalf[j];
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
    }
}