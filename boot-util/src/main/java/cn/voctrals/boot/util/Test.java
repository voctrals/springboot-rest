package cn.voctrals.boot.util;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试类
 *
 * @author LiuLei
 */
public class Test {

    public static void main(String[] args) {
        System.out.print(Constants.Tester.JUST_FOR_TEST);
        Gson gson = new Gson();

        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("name", "liulei");
        testMap.put("age", "12");
        testMap.put("gender", "male");

        String s = gson.toJson(testMap);
        System.out.println(s);
    }
}
