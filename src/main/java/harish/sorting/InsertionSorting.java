package harish.sorting;

public class InsertionSorting {
    public static void main(String[] args) {
        int[] array = {4, 3, 5, 7, 1, 56, 43, 55};
        insertionSort(array);
        for (int i: array)
            System.out.print(i + " ");

    }

    public static void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j= i-1;
            while(j >=0 && array[j] > key){
                array[j+1] = array[j];
                j -= 1;
            }
            array[j+1] = key;
        }
    }
}
