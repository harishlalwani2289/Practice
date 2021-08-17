package harish.array;

public class FindElementInRotatedArray {

    public static void main(String[] args) {
        int[] arr = {13,14,15,16,18,1,2,7,9,11};
        //In this we have to first find the pivot point
        // Here pivot will be index of 6 which is 3
        System.out.println(findPivot(arr));
        System.out.println(findElementInRotatedArray(arr,16));
    }

    private static int findElementInRotatedArray(int[] arr, int number) {

        int pivot = findPivot(arr);
        if(pivot == -1)
            return BinarySearch.binarySearch(arr,0,arr.length-1,number);
        else if(arr[pivot] == number)
            return pivot;
        else if (number >= arr[0])
            return BinarySearch.binarySearch(arr,0,pivot-1,number);
        else if (number <= arr[0])
            return BinarySearch.binarySearch(arr,pivot+1,arr.length-1, number);

        return -1;
    }

    private static int findPivot(int[] arr) {
        for(int i=1;i<arr.length;i++) {
            if(arr[i] < arr[i-1])
                return i-1;
        }
        return -1;
    }
}
