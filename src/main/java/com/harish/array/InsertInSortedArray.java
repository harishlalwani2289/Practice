package com.harish.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInSortedArray {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(6);
        arr.add(7);

        insert((ArrayList<Integer>) arr, arr.size(), 5);

        for(Object i: arr) {
            System.out.println(i);
        }
    }

    public static void insert(ArrayList<Integer> arr, int length, int number) {

        if(length == 0 || arr.get(length-1) <= number) {
            if(length < arr.size())
                arr.set(length, number);
            else
                arr.add(number);
            return;
        }
        int temp = arr.get(length - 1);
        insert(arr,length-1, number);
        if(length < arr.size())
            arr.set(length, temp);
        else
            arr.add(temp);
    }
}
