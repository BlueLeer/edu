package yxxy.atomic;

/**
 * @author WangLe
 * @date 2019/12/9 10:32
 * @description
 */
public class StringCacheTest {
    public static void main(String[] args) {
        // 同样的,使用这种方法会在堆中创建一个字符串常量-hello,使用下面这种方法创建字符串对象的时候,会直接指向堆中的同一个对象.
        String a = "hello";
        String b = "hello";
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}
