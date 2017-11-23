package cn.voctrals.boot.core.util;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.Errors;

public class MessagesUtils {

    public static void addErrors(MessageSource messageSource, Errors errors, String errorCode) {
    	//String field, String errorCode, Object[] errorArgs, String defaultMessage
    	errors.reject(errorCode);
    }

    
    public static String get(MessageSource messageSource, String code) {
        return get(messageSource, code, null);
    }

//    public static String get(MessageSource messageSource, String code, String param1) {
//    	String paramValue = get(messageSource, param1.toString());
//        return get(messageSource, code, new String[]{paramValue});
//    }
//
//    public static String get(MessageSource messageSource, String code, String param1, String param2) {
//    	return get(messageSource, code, new String[]{param1, param2});
//    }
//
//    public static String get(MessageSource messageSource, String code, String param1, String param2, String param3) {
//    	return get(messageSource, code, new String[]{param1, param2, param3});
//    }

    public static String get(MessageSource messageSource, String code, Object[] params) {
        String message = "";
        try {
            message = messageSource.getMessage(code, params, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException e) {
            message = "no message found by code:[" + code + "]";
        }
        return message;
    }

}
