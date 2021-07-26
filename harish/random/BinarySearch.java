package practice.harish.random;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1,3,6,13,14,78,89};
        int numberToSearch = 6;
        System.out.println("Index is : " + binarySearch(a, numberToSearch, 0, a.length-1));
    }

    private static int binarySearch(int[] a, int numberToSearch, int start, int end) {
        int mid =0;

        while(start < end) {
            mid = (start + end)/2;
            if(a[mid] == numberToSearch) {
                return mid;
            }
            else if(a[mid] < numberToSearch) {
                start = mid+1;
            }
            else {
                end =mid;
            }
        }
        return -1;
    }
}
