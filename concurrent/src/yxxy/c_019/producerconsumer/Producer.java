package yxxy.c_019.producerconsumer;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lee
 * @date 2020/4/22 15:11
 */
public class Producer implements Runnable {
    private final Queue<Integer> queue;
    private final int SIZE;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public Producer(Queue<Integer> queue, int size) {
        this.queue = queue;
        this.SIZE = size;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == SIZE) {
                    try {
                        // 释放锁
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                queue.add(atomicInteger.getAndIncrement());
                queue.notifyAll();
            }
        }
    }
}
