package harish.array;

public class SubArraysOfArray {
    public static void main(String[] args) {
        char array[] = {'a', 'b', 'c', 'd'};
        printAllSubArrays(array);
    }

    private static void printAllSubArrays(char[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(array[k] + "\t");
                }
                System.out.println();
            }
        }
    }
}