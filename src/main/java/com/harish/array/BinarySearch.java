package com.harish.array;

public class BinarySearch {

    public static int binarySearch(int[] arr, int low, int high, int number) {
        int mid = 0;
        while (low<=high) {
            mid = (high + low)/2;
            if(arr[mid] == number)
                return mid;
            if (arr[mid] > number) {
                high  = mid-1;
                binarySearch(arr,low,high,number);
            }
            if(arr[mid] < number) {
                low = mid+1;
                binarySearch(arr, low, high, mid);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,12,13,14,56,67,78};
        System.out.println(binarySearch(arr,0,arr.length-1, 9));
    }
}
