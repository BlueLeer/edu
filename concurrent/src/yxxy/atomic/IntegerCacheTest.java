package yxxy.atomic;

/**
 * @author WangLe
 * @date 2019/12/9 10:27
 * @description
 */
public class IntegerCacheTest {
    public static void main(String[] args) {
        // 使用这种方法创建的整形对象,Java会自动对其进行装箱,装箱的时候,会调用valueOf()方法,-128至127之间使用的都是缓存(java1.5开始)
        Integer a = 1;
        Integer b = 1;
        System.out.println(a == b); // true

        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d); // false
    }
}
