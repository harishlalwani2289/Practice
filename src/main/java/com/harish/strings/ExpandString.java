package com.harish.strings;

/*
Input : string x = "1-5, 8, 11-14, 18, 20, 26-29"
Output : string y = "1, 2, 3, 4, 5, 8, 11, 12,
                    13, 14, 18, 20, 26, 27, 28, 29"
 */
public class ExpandString {

    public static void main(String[] args) {
        String givenString = "1-5,8,10-12,13,16,19-21";
        expandString(givenString);
    }

    private static void expandString(String givenString) {

        String[] arr = givenString.split(",");
        StringBuilder result = new StringBuilder();
        for(String s : arr) {
            String[] subArray = s.split("-");
            if(subArray.length == 1)
                result.append(subArray[0]).append(", ");
            if(subArray.length == 2) {
                int a = Integer.parseInt(subArray[0]);
                int b = Integer.parseInt(subArray[1]);
                for(int i = a; i<=b ; i++)
                    result.append(i).append(", ");
            }
        }

        System.out.println(result);
    }
}
