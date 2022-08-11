package harish.array;

import java.util.Scanner;

public class CeilAndFloor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Enter the number to find ceil and floor");
        int number = scanner.nextInt();

        findCeilAndFloor(arr, number);
    }

    private static void findCeilAndFloor(int[] arr, int key) {

        int low = 0;
        int high = arr.length - 1;

        int ceil = Integer.MAX_VALUE;
        int floor = Integer.MIN_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (key < arr[mid]) {
                high = mid - 1;
                ceil = arr[mid];
            } else if (key > arr[mid]) {
                low = mid + 1;
                floor = arr[mid];
            } else {
                ceil = floor = arr[mid];
            }
        }

        System.out.println("Ceil :" +  ceil);
        System.out.println("Floor :" +  floor);
    }
}
