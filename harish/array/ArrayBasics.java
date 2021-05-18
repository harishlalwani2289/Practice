package practice.harish.array;

public class ArrayBasics {

    public static int findMaximum(int[] arr) {
        int maximumNumberIndex = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] > arr[maximumNumberIndex]){
                maximumNumberIndex = i;
            }
        }
        return maximumNumberIndex;
    }

    public static int findMinimum(int[] arr) {
        int minimumNumberIndex = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] < arr[minimumNumberIndex]){
                minimumNumberIndex = i;
            }
        }
        return minimumNumberIndex;
    }

    public static void main(String[] args) {
        int[] arr = {12,45,43,44,56,78,89,876,1,3,4,6};
        System.out.println(findMaximum(arr));
        System.out.println(findMinimum(arr));
    }
}
