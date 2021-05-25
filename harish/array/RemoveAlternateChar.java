package practice.harish.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RemoveAlternateChar {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        ArrayList<Character> array = new ArrayList<>();
        for(String curr : arr){
            array.add(curr.charAt(0));
        }
        System.out.println(array.toString());
        if(array.size()==1){
            System.out.println(array.get(0));
        }
        else {
            for (int i = 1; i < array.size(); i++) {
                array.remove(i);
            }
            System.out.println(array.toString());
        }
    }
}
