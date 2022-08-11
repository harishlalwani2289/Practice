package harish;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

public class HelloWorld {

    public static void main(String[] args) {
        Date myDate = new Date();
        System.out.println(myDate);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
        System.out.println(simpleDateFormat.format(myDate));
        System.out.println(String.valueOf(null));
    }
}
