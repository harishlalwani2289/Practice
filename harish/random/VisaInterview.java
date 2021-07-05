package practice.harish.random;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of strings, find all anagram pairs in the given array.
 * Example:
 *
 *
 * Input: arr[] =  {"geeksquiz", "geeksforgeeks", "abcd",
 *                  "forgeeksgeeks", "zuiqkeegs"};
 * Output: (geeksforgeeks, forgeeksgeeks), (geeksquiz, zuiqkeegs)
 */
public class VisaInterview {

    public static void main(String[] args) {
        String[] words = {"geeksquiz", "geeksforgeeks", "abcd","forgeeksgeeks", "zuiqkeegs"};

        for(int i=0;i< words.length;i++) {
            // for each word we will find if we have the anagram available in the list
            Map<Character,Integer> characterFrequencyMap = getCharacterFrequencyMap(words[i]);
            for(int j=i+1;j< words.length;j++) {
                Map<Character, Integer> characterFrequencyMap1 = getCharacterFrequencyMap(words[j]);
                if(compareTwoMaps(characterFrequencyMap, characterFrequencyMap1)) {
                    System.out.println(words[i]+ "," + words[j] );
                }
            }
        }
    }

    private static boolean compareTwoMaps(Map<Character, Integer> characterFrequencyMap, Map<Character, Integer> characterFrequencyMap1) {

        for(Map.Entry entry : characterFrequencyMap.entrySet()) {
            if(!(entry.getValue() == characterFrequencyMap1.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> getCharacterFrequencyMap(String word) {
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        for(Character ch : word.toCharArray()) {
            if(!characterFrequencyMap.containsKey(ch)) {
                characterFrequencyMap.put(ch,1);
            }
            characterFrequencyMap.put(ch, characterFrequencyMap.get(ch) + 1);
        }
        return characterFrequencyMap;
    }
}
