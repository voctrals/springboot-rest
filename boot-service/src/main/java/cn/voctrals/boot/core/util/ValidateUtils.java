package cn.voctrals.boot.core.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by liulei on 28/11/2016.
 */
public class ValidateUtils {
    /** 数字 */
    public static final String NUMERIC = "^[0-9]+$";
    /** 英数字 */
    public static final String ALPHANUMERIC = "^[A-Za-z0-9]+$";
    /** 手机号 */
    public static final String MOBILE = "^((13[0-9])|(14[5,7])|(15[^4,\\\\D])|(17[6-8])|(18[0-9]))\\\\d{8}$";
    /** 邮件 */
    public static final String EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public static boolean isNumeric(String value) {
        return Pattern.compile(NUMERIC).matcher(value).matches();
    }

//    public static boolean isPhone(String value) {
//        boolean ret = false;
//        if (!StringUtils.isEmpty(value) && isNumeric(value) && value.length() == 11) {
//            ret = true;
//        }
//        return ret;
//    }

    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
     */
    public static boolean isPhone(String str) {
        String regExp = "^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static boolean isPassword(String value) {
        boolean ret = true;
        if (StringUtils.isEmpty(value)) {
            return false;
        }

        int i = value.matches(".*\\d+.*") ? 1 : 0;
        int j = value.matches(".*[a-zA-Z]+.*") ? 1 : 0;
        int k = value.matches(".*[~!@#$%^&*()_+|<>,.?/:;'\\[\\]{}\"]+.*") ? 1 : 0;
        int l = value.length();

        if (i + j + k < 2 || l < 6 || l > 16) {
            ret = false;
        }

        return ret;
    }

    public static boolean isEmail(String email){
        return Pattern.compile(EMAIL).matcher(email).matches();
    }

    public static boolean isDate(String value) {
        boolean ret = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);

        try {
            sdf.parse(value);
            ret = true;
        } catch (ParseException e) {

        }

        return ret;
    }

    public static boolean isTime(String value) {
        boolean ret = false;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setLenient(false);

        try {
            sdf.parse(value);
            ret = true;
        } catch (ParseException e) {

        }

        return ret;
    }

    public static boolean compareTime(String value1, String value2) {
        boolean ret = false;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setLenient(false);

        try {
            Date date1 = sdf.parse(value1);
            Date date2 = sdf.parse(value2);
            ret = date1.before(date2);
        } catch (ParseException e) {

        }
        return ret;
    }

    public static int getWordCount(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int ascii = Character.codePointAt(s, i);
            if (ascii >= 0 && ascii <= 255)
                length++;
            else
                length += 2;

        }
        return length;

    }
}
