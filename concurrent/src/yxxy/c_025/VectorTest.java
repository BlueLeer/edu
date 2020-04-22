package yxxy.c_025;

import java.util.Vector;

/**
 * @author lee
 * @date 2020/1/16 14:55
 */
public class VectorTest {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("hello");
        vector.add("world");
        vector.add("java");
        vector.add("python");

        String s = vector.get(0);
    }
}
