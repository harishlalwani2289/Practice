package harish.random;

public class ConvertNumberToBinary {
    public static void main(String[] args) {
        int number = 33;
        System.out.println(numberToBinary(number));
    }

    public static String numberToBinary(int number) {
        if (number == 0 || number == 1) {
            return String.valueOf(number);
        }
        String temp = String.valueOf(number%2);
        return numberToBinary(number/2) + temp;
    }
}
