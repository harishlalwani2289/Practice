package harish.strings;

public class PermutationOfStringWithSpaces {

    public static void main(String[] args) {
        String input = "abc";
        String output = input.substring(0,1);

        //findPermutationWithSpace(input.substring(1),output);
        findPermutationWithCaseChange(input,"");

    }

    private static void findPermutationWithCaseChange(String input, String output) {
        if(input.length() == 0) {
            System.out.println(output);
            return;
        }
        String output1 = output + input.toUpperCase().charAt(0);
        String output2 = output + input.charAt(0);

        input = input.substring(1);

        findPermutationWithCaseChange(input,output1);
        findPermutationWithCaseChange(input, output2);


    }

    private static void findPermutationWithSpace(String input, String output) {

        if(input.length() == 0) {
            System.out.println(output);
            return;
        }

        String output1 = output + "_" + input.charAt(0);
        String output2 = output + input.charAt(0);
        input = input.substring(1);
        findPermutationWithSpace(input,output1);
        findPermutationWithSpace(input, output2);
    }
}
