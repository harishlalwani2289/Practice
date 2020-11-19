package com.harish.strings;

public class PrintSubsetsForString {
    public static void main(String[] args) {
        String input = "abc";
        String output = "";
        printAllSubsetsForString(input,output);
    }

    public static void printAllSubsetsForString(String input, String output) {
        if(input.length() == 0) {
            if(!(output.length() == 0))
                System.out.println(output);
            return;
        }
        String output1 = output;
        String output2 = output;

        output2 += input.charAt(0);
        input = input.substring(1);
        printAllSubsetsForString(input,output1);
        printAllSubsetsForString(input,output2);
    }
}
