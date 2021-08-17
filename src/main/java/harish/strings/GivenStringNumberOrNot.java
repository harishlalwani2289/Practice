package harish.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GivenStringNumberOrNot {

    public static void main(String[] args) {
        String input = "+23";
        System.out.println("Given String is" + (isStringNumber(input)?" a number ":" not a number " ));

        String input2 = "-10";
        System.out.println("Given String is" + (isStringFloatingPointNumber(input2)?" a floating point number ":" not a  floating point number " ));
    }

    private static boolean isStringFloatingPointNumber(String input) {
        String regex = "[+-]?[0-9]*(\\.[0-9])?";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()) {
            return true;
        }
        else {
            return false;
        }
    }

    public static Boolean isStringNumber(String input) {
        String regex = "[+-]?[0-9]+";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        if(matcher.find() && matcher.group().equals(input)) {
            return  true;
        }
        else {
            return  false;
        }

    }
}
