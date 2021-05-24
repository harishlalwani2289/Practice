package practice.harish.random;

public class SortedArrayConsolidation {

    public static void main(String[] args) {

        int[] a = {2,5,7,9,10,14};
        int[] b = {15,17,22,34};
        int[] output = new int[a.length + b.length];

        if (a==null || a.length == 0) {
            System.out.println("Invalid array a");
        }

        if (b==null || b.length == 0) {
            System.out.println("Invalid array b");
        }

        int i=0;
        int j=0;
        int k=0;
        while (i < a.length && j < b.length){

            if (a[i] <= b[j]) {
                output[k] = a[i];
                i++;
            }
            else if (a[i] > b[j]) {
                output[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < a.length) {
            output[k] = a[i];
            i++;
            k++;
        }
        while (j < b.length) {
            output[k] = b[j];
            j++;
            k++;
        }

        for(int s=0;s<output.length;s++) {
            System.out.print(output[s] + " ");
        }
    }
}
