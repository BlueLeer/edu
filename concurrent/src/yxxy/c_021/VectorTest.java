package yxxy.c_021;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Vector和ArrayList是同一种类型的,其功能几乎一是一致的,但是Vector是线程安全的
 * 当有2个以上的线程同时访问列表的时候,优先考虑使用Vector,当只有一个线程访问列表的时候,优先使用ArrayList
 *
 * @author WangLe
 * @date 2019/11/19 14:38
 * @description
 */
public class VectorTest {
    private static AtomicInteger index = new AtomicInteger();

    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                vector.add("hello: " + index.getAndIncrement());
            }).start();

        }


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        vector.forEach(s -> {
            System.out.println(s);
        });
    }

}
