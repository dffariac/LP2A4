package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class FormatarData {
    private static SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    public static Date formatarData(String dataString) {
        try {
            return formato.parse(dataString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
