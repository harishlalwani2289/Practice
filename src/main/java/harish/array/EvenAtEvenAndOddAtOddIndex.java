package harish.array;

/**
 * Given an array of size n containing equal number of odd and even numbers.
 * The problem is to arrange the numbers in such a way that all the even numbers get the even index and odd numbers get the odd index.
 * Required auxiliary space is O(1).
 * Examples :
 * <p>
 * <p>
 * Input : arr[] = {3, 6, 12, 1, 5, 8}
 * Output : 6 3 12 1 8 5
 * <p>
 * Input : arr[] = {10, 9, 7, 18, 13, 19, 4, 20, 21, 14}
 * Output : 10 9 18 7 20 19 4 13 14 21
 */
public class EvenAtEvenAndOddAtOddIndex {

    public static void main(String[] args) {
        int[] numbers = {3, 6, 12, 1, 5, 8,6,8,10,44};

        int evenInd = 0;
        int oddInd = 1;
        while (true) {
            while (evenInd < numbers.length && numbers[evenInd] % 2 == 0) {
                evenInd += 2;
            }

            while (oddInd < numbers.length && numbers[oddInd] % 2 == 1) {
                oddInd += 2;
            }

            if (evenInd < numbers.length && oddInd < numbers.length) {
                int temp = numbers[evenInd];
                numbers[evenInd] = numbers[oddInd];
                numbers[oddInd] = temp;
            } else
                break;
        }

        for(int i=0;i<numbers.length;i++) {
            System.out.println(numbers[i]);
        }

    }
}
