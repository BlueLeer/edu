package yxxy.c_015;

import java.util.concurrent.TimeUnit;

/**
 * @author lee
 * @date 2020/1/15 15:08
 */
public class T2 {
    private static volatile boolean flag = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while (flag) {
                doSomething();
            }
        }, "thread-1").start();
        
        new Thread(() -> {
            while (flag) {
                doSomething();
            }
        }, "thread-2").start();
        
        new Thread(() -> {
            while (flag) {
                doSomething();
            }
        }, "thread-3").start();

        // main线程睡眠3秒
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;

    }

    private static void doSomething() {
        System.out.println(System.currentTimeMillis() + "");
    }
}
