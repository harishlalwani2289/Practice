package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllNumberInString {
    public static void main(String[] args) {
        String input = "sdfj333sdkdfh33";
        System.out.println(findSumOfAllNumbersInString(input));
    }

    public static long findSumOfAllNumbersInString(String input) {
        long sum = 0;

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()) {
            sum = sum + Integer.parseInt(matcher.group());
        }
        return sum;
    }
}
