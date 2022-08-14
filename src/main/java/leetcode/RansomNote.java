package leetcode;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "errdedd";
        String magazine = "ddeefdd";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        for (int i = 0; i < ransomNote.length(); i++) {
            if (!magazine.contains(String.valueOf(ransomNote.charAt(i)))) {
                return false;
            } else {
                int indexOfChar = magazine.indexOf(ransomNote.charAt(i));
                if(indexOfChar == 0) {
                    magazine = magazine.substring(1);
                } else {
                    magazine = magazine.substring(0, indexOfChar) + magazine.substring(indexOfChar + 1);
                }
            }
        }

        return true;
    }
}
