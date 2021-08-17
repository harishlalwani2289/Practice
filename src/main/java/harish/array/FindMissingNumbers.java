package harish.array;

import java.util.Arrays;

public class FindMissingNumbers {

    public static void main(String[] args) {
        int[] input = { 1, 1, 2, 3, 5, 5, 7, 9, 9, 9 };

        int[] register = new int[input.length];

        for (int i: input) {
            register[i] = 1;
        }

        System.out.println("Missing numbers are :");

        for(int i =1; i< register.length;i++) {
            if(register[i] == 0) {
                System.out.println(i);
            }
        }

        findMissingNumbers();
    }

    public static void findMissingNumbers() {
        int[] numbers = { 11, 6, 4, 5, 7, 1 };
        Arrays.sort(numbers);
        int numbersArrayIndex = 0;
        for (int i = 0; i < numbers[numbers.length - 1]; i++) {
            if (i == numbers[numbersArrayIndex]) {
                numbersArrayIndex++;
            }
            else {
                System.out.println(i);
            }
        }
    }
}
