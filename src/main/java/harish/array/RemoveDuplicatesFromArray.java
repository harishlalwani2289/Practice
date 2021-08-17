package harish.array;

public class RemoveDuplicatesFromArray {

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,2,2,2,2,2,2,2,2,2,3,4,4,5,5,7,8,9};
        int j = removeDuplicates(arr, arr.length);

        for(int i=0;i<j;i++) {
            System.out.print(arr[i]);
        }
    }

    private static int removeDuplicates(int[] arr, int length) {
        int j=0;

        for (int i =0; i<arr.length-1;i++) {
            if(arr[i] != arr[i+1]) {
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[length-1];
        return j;
    }
}
