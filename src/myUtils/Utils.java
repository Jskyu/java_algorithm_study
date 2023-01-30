package myUtils;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class Utils {

    public static String dateToString(LocalDateTime date, String pattern){
        if(date == null) {
            return null;
        }
        try {
            return pattern == null ? date.format(DateTimeFormatter.BASIC_ISO_DATE) : date.format(DateTimeFormatter.ofPattern(pattern));
        } catch (Exception e) {
            //log
        }
        return null;
    }

    public static LocalDateTime stringToDate(String date, String pattern) {
        if(date == null) {
            return null;
        }
        try {
            return pattern == null ? LocalDateTime.parse(date, DateTimeFormatter.BASIC_ISO_DATE) : LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
        } catch (Exception e) {
            //log
        }
        return null;
    }

    public static <E> List<E> getOrEmptyList(List<E> list) {
        if(list == null) {
            list = Collections.emptyList();
        }
        return list;
    }

    public static String formatDecimal(double arg, String pattern){
        if(arg == 0.0) return "0";
        DecimalFormat format = pattern == null ? new DecimalFormat("#.####") : new DecimalFormat(pattern);
        return format.format(arg);
    }

    public static String formatDecimal(double arg){
        return formatDecimal(arg, null);
    }
}
