package yxxy.c_019.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 生产者和消费者模式的实现
 * 重点是:判断容器满了或者空了必须和后续的操作时原子性的,不能说你判断空了,然后再加锁去往里面扔东西,这样会引发问题
 *
 * @author lee
 * @date 2020/4/22 15:35
 */
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        final int size = 10;

        Consumer consumer = new Consumer(queue, size);
        Producer producer = new Producer(queue, size);

        for (int i = 0; i < 3; i++) {
            new Thread(producer).start();
        }

        // 睡眠500毫秒,保证所有的生产者都能启动起来
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(consumer).start();
        }
    }
}
