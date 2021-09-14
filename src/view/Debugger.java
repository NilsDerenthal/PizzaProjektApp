package view;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Debugger {

    public static void log (String s) {
        String timeStamp = new SimpleDateFormat("[dd.MM.yyyy HH:mm:ss] ").format(new Timestamp(System.currentTimeMillis()));
        System.out.println(timeStamp + s);
    }
}
