package harish.array;

public class MaximumSumSubArrayOFSizeK {

    public static void main(String[] args) {
        int[] arr = {1,2,5,43,3,21,-44,78,8,9,43,444,8,-123,77,-4};
        System.out.println(findMaximumSumSubArrayForSize(arr, 7));
    }

    public static int findMaximumSumSubArrayForSize(int[] arr, int k) {

        int i=0;
        int sum =0;
        int max;
        int index = i;

        for(i =0;i<k;i++){
            sum = sum + arr[i];
        }
        max = sum;

        for(i=k; i<arr.length;i++) {
            sum = sum - arr[i-k] + arr[i];
            if(sum > max) {
                max = sum;
                index =i-k+1;
            }
        }
        System.out.println("Numbers are" );
        for(i=index;i<index+k;i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println("Sum");
        return max;
    }
}
