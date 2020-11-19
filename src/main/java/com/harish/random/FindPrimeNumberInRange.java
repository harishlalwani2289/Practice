package random;

import org.apache.commons.compress.utils.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given String  0-20
Range 0-20
Now find all the prime numbers in given range and then calculate the most frequent occuring number
 */
public class FindPrimeNumberInRange {

    public static void main(String arg[]) {
        String input = "20-1000";

        Integer[] values = getIntegerValues(input);
        int start = values[0];
        int end = values[1];

        // Lets find the prime number between start and end
        String primeNumbers = findPrimeNumbersWithinRange(start,end);
        System.out.println(primeNumbers);

        Integer answer = findMostFrequentDigit(primeNumbers);
        System.out.println(answer + " is the most frequent digit");
    }

    private static Integer findMostFrequentDigit(String primeNumbers) {

        HashMap<Character,Integer> results = new HashMap<Character, Integer>();
        for(int i=0;i<primeNumbers.length();i++) {
            results.put(primeNumbers.charAt(i), results.getOrDefault(primeNumbers.charAt(i),0) +1);
        }
        int max =0;
        int answer = 0;
        for(Map.Entry<Character,Integer> entry : results.entrySet()) {
            if(entry.getValue() > max){
                answer = entry.getKey();
                max = entry.getValue();
            }
        }
        return answer-48;
    }


    private static String findPrimeNumbersWithinRange(int start, int end) {
        int flag;
        String primeNumbers= "";
        for(int i=start; i<=end ; i++) {
            flag = 1;
            for(int j=2; j<i;j++) {
                if(i%j==0) {
                    flag = 0;
                    break;
                }
            }
            if (flag==1) {
                primeNumbers = primeNumbers + i;
            }
        }

        return primeNumbers;
    }

    private static Integer[] getIntegerValues(String input) {

        String[] values = input.split("-");
        Integer[] intValues = {Integer.parseInt(values[0]), Integer.parseInt(values[1])};

        return intValues;

    }
}
