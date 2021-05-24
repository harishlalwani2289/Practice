package practice.harish.array;

public class FindMissingNumber {

    public static void main(String[] args) {

        int[] numbers = {1,2,4,5,6,7,8,9};
        int start = 0;
        int end = numbers.length - 1;
        int mid = 0;
        while (start < end -1) {
            mid = (start + end)/2;
            if(numbers[mid] - mid > 1) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        System.out.println(numbers[start] + 1);

    }
}
