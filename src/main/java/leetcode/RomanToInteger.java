package leetcode;

import java.util.Scanner;

public class RomanToInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String romanString = scanner.nextLine();

        System.out.println(romanToInt(romanString));
    }

    public static int romanToInt(String romanString) {

        int result = 0;
        for (int i = 0; i < romanString.length(); i++) {
            switch (romanString.charAt(i)) {
                case 'V':
                    result += 5;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
                case 'I':
                    if(i+1 < romanString.length() && romanString.charAt(i+1) == 'V'){
                        result += 4;
                        i++;
                    } else if(i+1 < romanString.length() && romanString.charAt(i+1) == 'X'){
                        result += 9;
                        i++;
                    } else {
                        result += 1;
                    }
                    break;
                case 'X':
                    if(i+1 < romanString.length() && romanString.charAt(i+1) == 'L'){
                        result += 40;
                        i++;
                    } else if(i+1 < romanString.length() && romanString.charAt(i+1) == 'C'){
                        result += 90;
                        i++;
                    } else {
                        result += 10;
                    }
                    break;
                case 'C':
                    if(i+1 < romanString.length() && romanString.charAt(i+1) == 'D'){
                        result += 400;
                        i++;
                    } else if(i+1 < romanString.length() && romanString.charAt(i+1) == 'M'){
                        result += 900;
                        i++;
                    } else {
                        result += 100;
                    }
                    break;
                default:
                    break;
            }
        }

        return result;
    }
}
