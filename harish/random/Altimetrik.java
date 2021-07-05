package practice.harish.random;

public class Altimetrik {
    public static void main(String[] args) {
        int[] numbers = {1,3,5,7,9};
        int x=17;
        int diff = Integer.MAX_VALUE;
        int firstNumber = 0;
        int secondNumber = 0;
        for(int i=0;i<numbers.length-1;i++) {

            for(int j=i+1;j<numbers.length;j++) {
                int currDiff = Math.abs((numbers[i] + numbers[j]) - x);
                if(currDiff < diff) {
                    diff = currDiff;
                    firstNumber = numbers[i];
                    secondNumber = numbers[j];
                }
            }
        }
        System.out.println("Pair is : " + firstNumber + " " + secondNumber);
     }
}
