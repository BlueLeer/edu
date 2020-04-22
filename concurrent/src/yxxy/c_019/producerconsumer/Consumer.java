package yxxy.c_019.producerconsumer;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * @author lee
 * @date 2020/4/22 15:32
 */
public class Consumer implements Runnable {
    private final Queue<Integer> queue;
    private final int SIZE;

    public Consumer(Queue<Integer> queue, int SIZE) {
        this.queue = queue;
        this.SIZE = SIZE;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == 0) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Integer poll = queue.poll();
                System.out.println("我是消费者,我消费到数据了: " + poll);
                // 睡眠200毫秒,模拟业务处理
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                queue.notifyAll();
            }
        }
    }
}
