package am.itspace.healthcaremanagement.utill;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class DateUtil {

    private static final DateTimeFormatter SDF = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");


    public static String dateToString(Date date) {
        if (date == null) {
            return null;
        }
        return SDF.format((TemporalAccessor) date);
    }

    public static Date dateToString(String dateStr) throws ParseException {
        if (dateStr == null) {
            return null;
        }
        return (Date) SDF.parse(dateStr);
    }


}
