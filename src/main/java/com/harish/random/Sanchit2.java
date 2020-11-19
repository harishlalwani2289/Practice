package random;

/*
Given 2 strings
Check whether it is rotated by two places or not
Example: Amazon Azonam
 */
public class Sanchit2 {

    public static void main(String arg[]) {
        String string1 = "AMAZON";
        String string2 = "ONAMAZ";

        if(string2.charAt(0) == string1.charAt(2)) {
            System.out.println(string1 + " is rotated twice clockwise forming " + string2 );
        }
        if(string1.charAt(0) == string2.charAt(2)) {
            System.out.println(string1 + " is rotated twice anti-clockwise forming " + string2 );
        }
    }
}
