package yxxy.c_025;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class T05_LinkedBlockingQueue {

    // 底层是基于单向链表实现的阻塞队列,通常用作无界队列来使用
    // 与ArrayBlockingQueue相比,它有更高的吞吐量,但是为了避免其容量快速的扩增,从而损耗大量的内存
	static BlockingQueue<String> strs = new LinkedBlockingQueue<>();

	static Random r = new Random();

	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				try {
					strs.put("a" + i); //如果满了，就会等待,小细节:对于有界队列,插入的时候,如果队列已经满了才会阻塞,对于无界队列,放入新的元素的时候是不会阻塞的
					TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "p1").start();

		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				for (;;) {
					try {
						System.out.println(Thread.currentThread().getName() + " take -" + strs.take()); //如果空了，就会等待
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}, "c" + i).start();

		}
	}
}
