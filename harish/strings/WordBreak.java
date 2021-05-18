package string;

import java.util.HashSet;
import java.util.Set;

/**
 * iven an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words. See following examples for more details.
 * This is a famous Google interview question, also being asked by many other companies now a days.
 *
 * Consider the following dictionary
 * { i, like, sam, sung, samsung, mobile, ice,
 *   cream, icecream, man, go, mango}
 *
 * Input:  ilike
 * Output: Yes
 * The string can be segmented as "i like".
 *
 * Input:  ilikesamsung
 * Output: Yes
 * The string can be segmented as "i like samsung"
 * or "i like sam sung".
 */
public class WordBreak {

    public static Set<String> dictionary = new HashSet<>();
    public static void main(String[] args) {
        String input = "ilike";
        String[] dict = { "i", "like", "sam", "sung", "samsung", "mobile"};
        // First we have to store these words in a set
        for(String s : dict) {
            dictionary.add(s);
        }
        System.out.println(input.substring(5));
        System.out.println(wordBreak("isamlikemobile"));
    }

    private static boolean wordBreak(String word) {
        if(word.length() == 0) {
            return true;
        }
        for(int i=1;i<=word.length();i++) {
            if(dictionary.contains(word.substring(0,i)) &&
                wordBreak(word.substring(i)))
                return true;
        }
        return false;
    }
}
