package harish.array;

public class InverseOfArray {

    public static void main(String[] args) {
        int a[] = {3, 0, 4, 2, 1};
        int inverse_a[] = inverseOfArray(a);
        for(int i:inverse_a) {
            System.out.print(" " + i);
        }
    }

    public static int[] inverseOfArray(int[] a) {
        int b[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[a[i]] = i;
        }
        return b;
    }
}
