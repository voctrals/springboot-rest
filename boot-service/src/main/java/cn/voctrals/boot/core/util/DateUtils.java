package cn.voctrals.boot.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liulei on 04/03/2017.
 */
public class DateUtils {

    public static final String PATTERN_YYYYMMDD = "yyyy-MM-dd";

    public static final String PATTERN_HHMM = "HH:mm";

    public static Date parseDate(String strDate) {
        return parseDate(strDate, PATTERN_YYYYMMDD);
    }

    public static Date parseDate(String strDate, String pattern) {
        Date ret = null;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        try {
            ret = formatter.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static Date parseTime(String strDate) {
        return parseDate(strDate, PATTERN_HHMM);
    }

    public static Date parseTime(String strTime, String pattern) {
        Date ret = null;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        try {
            ret = formatter.parse(strTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YYYYMMDD);
        return sdf.format(date);
    }

    public static String formatTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_HHMM);
        return sdf.format(date);
    }
}
