package practice.harish.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexGroupExample {
    public static void main(String[] args) {
        String datesStr = "22/12/2019";

        Pattern datePatt = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
        Matcher m = datePatt.matcher(datesStr);
        if (m.matches()) {
            int day   = Integer.parseInt(m.group(1));
            int month = Integer.parseInt(m.group(2));
            int year  = Integer.parseInt(m.group(3));

            System.out.println(day + "  " + month + " " + year);
        }


    }
}
