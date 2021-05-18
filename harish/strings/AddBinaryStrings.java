package practice.harish.strings;

public class AddBinaryStrings {

    public static String addBinaryStrings(String a, String b) {

        // Store Result
        String result = "";
        // Sum of digit

        int  i = a.length()-1;
        int  j = b.length()-1;
        int carry  = 0;

        while(i>=0 || j >= 0) {
            int vi = 0;
            int vj = 0;

            if(i>=0) {
                vi = a.charAt(i) == '0'?0:1;
                i--;
            }

            if (j >=0) {
                vj = b.charAt(j) == '0'?0:1;
                j--;
            }

            int sum  = vi+ vj+ carry;

            if(sum>=2) {
                result = result + String.valueOf(sum-2);
                carry = 1;
            }
            else {
                result = result + String.valueOf(sum);
                carry = 0;
            }
        }

        if (carry == 1) {
            result = result + "1";
        }

        StringBuilder sb = new StringBuilder(result);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        addBinaryStrings("1000", "111");
    }

}
