package random;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToString {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(date));

    }
}
