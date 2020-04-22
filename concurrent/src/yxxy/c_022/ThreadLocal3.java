package yxxy.c_022;

import java.util.concurrent.TimeUnit;

/**
 * @author WangLe
 * @date 2019/11/14 11:09
 * @description
 */
public class ThreadLocal3 {
    public static void main(String[] args) {
        String s = new String("hello");
        ThreadLocal<String> threadLocalMain = new ThreadLocal<>();
        threadLocalMain.set(s);

        new Thread(() -> {
            threadLocalMain.set(s);
            String s1 = threadLocalMain.get();
            s1 = new String("no hello");
        }).start();

        new Thread(() -> {
            threadLocalMain.set("hahah");
        });

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
        }
        System.out.println(s);

    }
}
