package harish.array;

import java.util.Scanner;

public class SubsetsOfAnArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        int limit = (int) Math.pow(2, arr.length);
        for (int i = 0; i < limit; i++) {
            // convert i to binary and use 0 and 1 to use to decide to print the array elemnt or not
            String set = "";
            int temp = i;
            for (int j = arr.length - 1; j >= 0; j--) {
                int r = temp % 2;
                temp = temp / 2;

                if (r == 0) {
                    set = "-  " + set;
                } else {
                    set = arr[j] + "  " + set;
                }
            }
            System.out.println(set);
        }
    }
}
