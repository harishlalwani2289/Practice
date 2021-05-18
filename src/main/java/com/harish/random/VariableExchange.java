package practice.src.main.java.com.harish.random;

import java.util.Scanner;

public class VariableExchange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String variable = scanner.nextLine();

        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < variable.length(); i++) {
            if ('_' == variable.charAt(i)) {
                i++;
                output = output.append(Character.toUpperCase(variable.charAt(i)));
            } else if (Character.isUpperCase(variable.charAt(i)))
                output = output.append("_" + Character.toLowerCase(variable.charAt(i)));
            else {
                output = output.append(variable.charAt(i));
            }
        }
        System.out.println(output);
    }
}