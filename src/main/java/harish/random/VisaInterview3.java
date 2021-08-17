package harish.random;

/**
 * r****i@****.com
 */
public class VisaInterview3 {
    public static void main(String[] args) {
        String email = "ranjini@gmail.com";
        String result = "";

        String id = email.substring(0, email.indexOf("@"));
//        String idReplaced = id.replace(id.substring(1,id.length()-1), "*");
//        System.out.println(idReplaced);
        result += String.valueOf(id.charAt(0));
        for (int i = 1; i < id.length() - 1; i++) {
            result += "*";
        }
        result += String.valueOf(id.charAt(id.length() - 1));
        result += "@";

        for (int i = email.indexOf("@") + 1; i < email.indexOf("."); i++) {
            result += "*";
        }
        result += email.substring(email.indexOf("."), email.length());
        System.out.println(result);
    }
}
