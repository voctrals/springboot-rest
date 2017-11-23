package cn.voctrals.boot.core.util;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

/**
 * Created by liulei on 20/02/2017.
 */
public class CacheUtils {

    public static void put(Cache cache, Object key, Object value) {
        cache.put(key, value);
    }

    public static boolean containsKey(Cache cache, Object key) {
        return cache.get(key) != null;
    }

    public static Object getValue(Cache cache, Object key) {
        Object ret = null;
        SimpleValueWrapper value = (SimpleValueWrapper)cache.get(key);
        if (value != null) {
            ret = value.get();
        }
        return ret;
    }

    public static String getStringValue(Cache cache, Object key) {
        String ret = null;
        Object obj = getValue(cache, key);
        if (obj != null) {
            ret = obj.toString();
        }
        return ret;
    }

    public static void remove(Cache cache, Object key) {
        cache.evict(key);
    }
}
