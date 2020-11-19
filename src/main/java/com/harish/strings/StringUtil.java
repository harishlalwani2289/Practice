package com.harish.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringUtil {

    public static void main(String[] args) {
        String input = "mi esposa nombre es pratiksha";
//        capitalizeFirstLetterOfEachWord(input);
//        capitalizeFirstAndLastLetterOfEachWord(input);
//        printFirstAndLastCharacterOfEachWord(input);
//        reverseStringExceptFirstAndLastCharacter("harish");
//        reverseEachWordExceptFirstAndLastCharacter(input);
//        split(input, " ");
//        reverseTheStringWords(input);
//        System.out.println(addTwoStringsArithmetically("9999999999999999", "9999999999999999"));
        System.out.println(divisibilityBy11("781"));
    }

    public static boolean divisibilityBy11(String s) {
        // Odd digits are at even indexes and even digits are at odd indexes
        int evenSum =0;
        int oddSum = 0;
        for(int i=0;i<s.length();i++) {
            if(i%2 == 0)
                oddSum = oddSum + (s.charAt(i) - '0');
            else
                evenSum = evenSum + (s.charAt(i) - '0');
        }
        return (oddSum-evenSum)%11 == 0;
    }

    public static String addTwoStringsArithmetically(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        String resultString = "";
        int carry = 0;
        int i=1;

        while((length1-i) >= 0 && (length2-i) >=0 ) {
            int result = (s1.charAt(length1 - i) - '0') + (s2.charAt(length2 - i) - '0') + carry;
            char ch = (char) ((result % 10) + '0');
            resultString = ch + resultString;
            carry = result / 10;
            i++;
        }

        while(length1-i >= 0) {
            int result = (s1.charAt(length1 - i) - '0') + carry;
            char ch = (char) ((result % 10) + '0');
            resultString = ch + resultString;
            carry = result / 10;
            i++;
        }

        while(length2-i >= 0) {
            int result = (s2.charAt(length2 - i) - '0') + carry;
            char ch = (char) ((result % 10) + '0');
            resultString = ch + resultString;
            carry = result / 10;
            i++;
        }

        if(carry > 0) {
            char ch = (char) (carry + '0');
            resultString = ch + resultString;
        }

        return resultString;

    }

    public static void reverseTheStringWords(String input) {
        List<String> tokens = split(input, " ");
        Collections.reverse(tokens);
        String result = tokens.stream().reduce("", (s1, s2) -> s1 + s2 + " ").trim();
        System.out.println(result);

    }

    public static List<String> split(String input, String sep) {
        List<String> tokens = new ArrayList<>();
        String token = "";
        for (int i = 0; i < input.length(); i++) {
            if (String.valueOf(input.charAt(i)).equals(sep)) {
                tokens.add(token);
                token = "";
            } else
                token = token + input.charAt(i);
        }
        tokens.add(token);
        return tokens;
    }

    private static void reverseEachWordExceptFirstAndLastCharacter(String input) {

        String[] tokens = input.split(" ");
        String result = "";
        for (String s : tokens) {
            result = result + reverseStringExceptFirstAndLastCharacter(s) + " ";
        }
        System.out.println(result);
    }

    private static String reverseStringExceptFirstAndLastCharacter(String word) {
        char[] strArray = word.toCharArray();
        int i = 1; // Pointing to second character
        int j = word.length() - 2;

        while (i < j) {
            char temp = strArray[i];
            strArray[i] = strArray[j];
            strArray[j] = temp;
            i++;
            j--;
        }

        word = new String(strArray);
        return word;
    }

    public static void printFirstAndLastCharacterOfEachWord(String input) {
        String[] words = input.split(" ");

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(" ").append(String.valueOf(word.charAt(0))).append(word.charAt(word.length() - 1));
        }
        System.out.println(result);
    }

    private static void capitalizeFirstAndLastLetterOfEachWord(String input) {
        String[] words = input.split(" ");

        StringBuilder result = new StringBuilder(
                words[0].toUpperCase().charAt(0)
                        + words[0].substring(1, words[0].length() - 1)
                        + words[0].toUpperCase().charAt(words[0].length() - 1));

        for (int i = 1; i < words.length; i++) {
            result.append(" ").append(capitalize(
                    words[i].toUpperCase().charAt(0)
                            + words[i].substring(1, words[i].length() - 1)
                            + words[i].toUpperCase().charAt(words[i].length() - 1)));
        }
        System.out.println(result);
    }

    private static void capitalizeFirstLetterOfEachWord(String input) {

        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder(capitalize(words[0]));
        for (int i = 1; i < words.length; i++) {
            result.append(" ").append(capitalize(words[i]));
        }
        System.out.println(result);
    }

    public static
    String capitalize(String word) {
        return word.toUpperCase().charAt(0) + word.substring(1);
    }
}