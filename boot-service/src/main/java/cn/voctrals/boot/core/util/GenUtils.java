package cn.voctrals.boot.core.util;

import org.apache.shiro.crypto.hash.Sha256Hash;

import java.util.UUID;

/**
 * Created by liulei on 27/11/2016.
 */
public class GenUtils {

    private static final String SALT = "boot";

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String encrypt(String str) {
        return new Sha256Hash(str, SALT).toString();
    }

    public static String vcode() {
        return String.valueOf((int)((Math.random() * 9 + 1) * 100000));
    }

}
