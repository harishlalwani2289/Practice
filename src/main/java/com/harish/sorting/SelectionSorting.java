package com.harish.sorting;

public class SelectionSorting {

    public static void main(String[] args) {
        int a[] = new int[]{4, 2, 6, 2, 9, 8, 56, 43, 33};
        System.out.println(a.length);
        sort(a);
        System.out.println("Sorted Array : ");
        for (int i =0; i<a.length;i++)
            System.out.println(a[i]);
    }

    private static void sort( int[] a) {
        int imin = 0;
        for(int i=0;i< a.length - 1; i++) {
            imin = i;
            for(int j = i+1; j<a.length;j++){
                if(a[i] > a[j])
                    imin = j;
            }
            // swap the position
            int temp = a[i];
            a[i] = a[imin];
            a[imin] = temp;
        }

    }

}
