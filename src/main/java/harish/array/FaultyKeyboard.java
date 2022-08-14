package harish.array;

import java.util.Scanner;

public class FaultyKeyboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String typed = scanner.nextLine();

        System.out.println(isLongPressedName(name, typed));
    }

    public static boolean isLongPressedName(String name, String typed) {

        int i = 0;
        int j = 0;

        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (i > 0 && name.charAt(i - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }

        while (j < typed.length()) {
            if (name.charAt(i - 1) != typed.charAt(j))
                return false;
            j++;
        }
        return true;
    }
}
