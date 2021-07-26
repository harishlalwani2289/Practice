package practice.harish.sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {12,18,15,21,19,30,4,17};
        quickSort(arr, 0, arr.length-1);
        System.out.println("After quick sort");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(start < end) {
            int pivotIndex = partition(arr, start, end);
            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {

        int pivot = arr[end];
        int pivotIndex = start -1;

        for(int j= start; j<= end-1;j++) {
            if(arr[j] <= pivot) {
                pivotIndex++;
                int temp = arr[pivotIndex];
                arr[pivotIndex] = arr[j];
                arr[j] = temp;
            }
        }
        pivotIndex++;
        int temp = arr[end];
        arr[end] = arr[pivotIndex];
        arr[pivotIndex] = temp;
        return pivotIndex;
    }
}
