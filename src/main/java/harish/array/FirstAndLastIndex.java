package harish.array;

import java.util.Scanner;

public class FirstAndLastIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Enter the number to find index and last index");
        int number = scanner.nextInt();

        findFirstAndLastIndex(arr, number);
    }

    private static void findFirstAndLastIndex(int[] arr, int number) {
        int low = 0;
        int high = arr.length -1 ;
        int fi =-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if(number > arr[mid]) {
                low = mid +1;
            } else if(number < arr[mid]) {
                high = mid -1;
            } else {
                fi = mid;
                high = mid - 1;
            }
        }
        System.out.println("First Index : " + fi);

        int li = -1;
        low = 0;
        high = arr.length -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(number > arr[mid]) {
                low = mid +1;
            } else if(number < arr[mid]) {
                high = mid -1;
            } else {
                li = mid;
                low = mid + 1;
            }
        }
        System.out.println("Last Index :" + li);
    }
}
