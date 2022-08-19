package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">...</a>}
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
 * that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 * <p>
 * Input: digits = ""
 * Output: []
 * Example 3:
 * <p>
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinationOfAPhoneNumber {

    static String[] codes = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        String digits = "2346";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        addCodesForNumber(digits.charAt(0) - 48, result);
        for (int i = 1; i < digits.substring(1).length(); i++) {
            addCodesForNumber(digits.charAt(i) - 48, result);
        }
        return null;
    }

    private static void addCodesForNumber(int number, List<String> result) {
        for (int i = 0; i < codes[number].length(); i++) {
            result.add(String.valueOf(codes[number].charAt(i)));
        }
    }
}
