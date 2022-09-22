package harish.strings;

import java.util.*;
import java.io.*;

public class StringChallenge {

    public static int StringChallenge(String str) {
        // code goes here
        if(str.length() == 0) return 0;
        if(str.length() < 2) return 1;

        for(int i =0;i<str.length()-1;i++) {
            if(str.charAt(i) != str.charAt(i+1)) {
                return StringChallenge(str.substring(0,i) + findReplaceChar(str.charAt(i), str.charAt(i+1)) + str.substring(i+2));
            }
        }
        return str.length();
    }

    private static String findReplaceChar(char ch1, char ch2) {
        if(ch1 == 'a' && ch2 == 'b')
            return String.valueOf('c');
        if(ch1 == 'b' && ch2 == 'a')
            return String.valueOf('c');
        if(ch1 == 'b' && ch2 == 'c')
            return String.valueOf('a');
        if(ch1 == 'c' && ch2 == 'b')
            return String.valueOf('a');
        if(ch1 == 'a' && ch2 == 'c')
            return String.valueOf('b');
        if(ch1 == 'c' && ch2 == 'a')
            return String.valueOf('b');
        return null;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(StringChallenge(s.nextLine()));
    }

}