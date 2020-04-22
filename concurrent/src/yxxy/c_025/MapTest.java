package yxxy.c_025;

import java.util.*;

/**
 * @author WangLe
 * @date 2019/11/21 14:02
 * @description
 */
public class MapTest {
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    public static void test1() {
//        Map<String, String> map = new HashMap<>();
//        Map<String,String> map = new TreeMap<>();
        Map<String, String> map = new LinkedHashMap<>();
        map.put("afasdf", "A");
        map.put("cfasdfa", "C");
        map.put("bfasdf", "B");
        map.put("dfasdfsad", "D");
        map.put(null, "D");

        Set<String> strings = map.keySet();
        strings.forEach(s -> System.out.println(s));

    }

    public static void test2() {
        String s1 = "hello";
        String s2 = "hahaha";

        System.out.println("s1: " + s1.hashCode());
        System.out.println("s2: " + s2.hashCode());
    }

    public static void test3() {
        int i = 5 & 8;
        System.out.println(i);
    }
}
