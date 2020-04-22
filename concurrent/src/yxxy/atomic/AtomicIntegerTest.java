package yxxy.atomic;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lee
 * @date 2020/1/17 12:15
 */
public class AtomicIntegerTest {
    private static int value = 1;
    private static int value2 = 1;
    // 报错: SecurityException,该类能在那些是由Bootstrap类加载器中的类才能使用
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    public static void main(String[] args) throws NoSuchFieldException {
//        testAtomicInteger();
//        testUnsafe();
    }

    private static void testAtomicInteger() {
        AtomicInteger atomicInteger = new AtomicInteger(1);

        atomicInteger.getAndIncrement();

        atomicInteger.compareAndSet(2, 100);

        // getAndIncrement()和compareAndSet()底层都调用了compareAndSwapInt()方法,CAS
    }

    private static void testUnsafe() throws NoSuchFieldException {
        long valueOffset1 = unsafe.objectFieldOffset(AtomicIntegerTest.class.getDeclaredField("value"));
        long valueOffset2 = unsafe.objectFieldOffset(AtomicIntegerTest.class.getDeclaredField("value2"));

        System.out.println("valueOffset1: "+valueOffset1);
        System.out.println("valueOffset2: "+valueOffset2);
        
    }
}
