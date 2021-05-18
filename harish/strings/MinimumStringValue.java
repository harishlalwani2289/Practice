package string;

import java.util.HashMap;
import java.util.Map;

/*
Given a string of lowercase alphabets and a number k, the task is to print the minimum value of the string after removal of ‘k’ characters. The value of a string is defined as the sum of squares of the count of each distinct character. For example consider the string “saideep”, here frequencies of characters are s-1, a-1, i-1, e-2, d-1, p-1 and value of the string is 1^2 + 1^2 + 1^2 + 1^2 + 1^2 + 2^2 = 9.

Expected Time Complexity: O(k*logn)

Examples
Input :  str = abccc, K = 1
Output :  6
We remove c to get the value as 12 + 12 + 22

Input :  str = aaab, K = 2
Output :  2
 */
public class MinimumStringValue {

    public static void main(String[] args) {
        String input = "hhhgggyyy";
        int k = 2;

        // First lets store the frequency of each character of String in a map
        Map<Character,Integer> charMap = new HashMap<>();

        for (char c : input.toCharArray()) {
            if(!charMap.containsKey(c)) {
                charMap.put(c,0);
            }
            charMap.put(c,charMap.get(c) + 1);
        }
        System.out.println(charMap);

        // Now remove the charcter frequency one by one k times
        // starting from the highest frequency element
        while ( k>0) {
            char c = findTheMapEntryWithHighestValue(charMap);
                k--;
                charMap.put(c,charMap.get(c) -1);
        }

        long result = 0;
        // Now we have the map with all the values to minimum which will give us the minimum
        // Lets get the String value now
        for(Character c : charMap.keySet()) {
            result = result + charMap.get(c)*charMap.get(c);
        }

        System.out.println(result);
    }

    private static char findTheMapEntryWithHighestValue(Map<Character,Integer> charMap) {
        char maxFrequencyCharacter = 0;
        int maxFrequency = 0;
        for (Character c : charMap.keySet()) {
            if(charMap.get(c) > maxFrequency) {
                maxFrequency = charMap.get(c);
                maxFrequencyCharacter = c;
            }
        }
        return maxFrequencyCharacter;
    }
}
