package yxxy.c_019;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 曾经的面试题：（淘宝？）
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 *
 * @author lee
 * @date 2020/4/22 15:46
 */
public class LeeContainer {
    private List<Integer> list = new ArrayList<>();
    private int size = 0;
    // 线程1和2共享的
    private volatile boolean shouldStop = false;
    private Object o = new Object();
    AtomicInteger integer = new AtomicInteger(0);

    public void add() {
        for (int i1 = 0; i1 < 10; i1++) {
            if (shouldStop) {
                break;
            }

            list.add(integer.getAndIncrement());
            size++;
        }


    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LeeContainer leeContainer = new LeeContainer();
        new Thread(() -> {
            while (true) {
                if (leeContainer.size() == 5) {
                    leeContainer.shouldStop = true;
                    break;
                }
            }
        }).start();
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            leeContainer.add();
        }).start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("执行结束: " + leeContainer.size());
    }
}
