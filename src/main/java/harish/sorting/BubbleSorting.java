package harish.sorting;

public class BubbleSorting {
    public static void main(String[] args) {
        int a[] = new int[]{4, 2, 6, 2, 9, 8, 56, 43, 33};
        sort(a);
        System.out.println("Sorted array after bubble sorting : ");
        for (int i: a)
            System.out.print(i + " ");
    }

    private static void sort(int[] a) {

        for(int k = 0; k< a.length-1;k++)
        {
            for(int i=0; i< a.length-k-1; i++) {
                if(a[i] > a[i+1]) {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
        }
    }
}
