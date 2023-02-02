package myUtils;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class Utils {

    /* --- DATE Utils START --- */
    public static String dateTimeToString(LocalDateTime date, String pattern){
        try {
            return pattern == null ? date.format(DateTimeFormatter.BASIC_ISO_DATE) : date.format(DateTimeFormatter.ofPattern(pattern));
        } catch (Exception e) {
            //error log
            return null;
        }
    }

    public static LocalDateTime stringToDateTime(String date, String pattern) {
        if(date == null) {
            return null;
        }
        try {
            return pattern == null ? LocalDateTime.parse(date, DateTimeFormatter.BASIC_ISO_DATE) : LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
        } catch (Exception e) {
            //error log
            return null;
        }
    }

    public static String dateToString(LocalDate date, String pattern){
        try {
            return pattern == null ? date.format(DateTimeFormatter.BASIC_ISO_DATE) : date.format(DateTimeFormatter.ofPattern(pattern));
        } catch (Exception e) {
            //error log
            return null;
        }
    }

    public static LocalDate stringToDate(String date, String pattern) {
        try {
            return pattern == null ? LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE) : LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
        } catch (Exception e) {
            //error log
            return null;
        }
    }

    public static boolean isBetweenDate(LocalDateTime from, LocalDateTime to, LocalDateTime target) {
        try {
            return target.isAfter(from) && target.isBefore(to);
        } catch (Exception e) {
            //error log
            return false;
        }
    }
    /* --- DATE Utils END --- */

    public static <E> List<E> getOrEmptyList(List<E> list) {
        return list == null ? Collections.emptyList() : list;
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
