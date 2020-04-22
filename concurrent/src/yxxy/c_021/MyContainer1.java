/**
 * 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * 
 * 使用wait和notify/notifyAll来实现
 * 
 * @author mashibing
 */
package yxxy.c_021;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class MyContainer1<T> {
	final private LinkedList<T> lists = new LinkedList<>();
	final private int MAX = 10; //最多10个元素
	private int count = 0;
	
	
	public synchronized void put(T t) {
	    // effective java一书中说过,99%的情况下,wait()是和while一起使用的
        // 当生产者线程被唤醒的时候,如果当前容器是满的,不能说不让人家生产了,需要等着,持续的等着
        // 如果使用if,当前如果容器满了,调用wait()释放锁,然后等着,下次线程被唤醒以后,执行从add(t)开始了,
        // 不会重复判断了,如果此时容器还是满的,再被唤醒就会出现问题了
        // 场景: 2个put的线程因为容器满了,都在等着,此时get取走一个以后,唤醒两个put线程,其中一个put线程能够往容器里面放东西,放完以后容器又慢了,另一个线程一定又会往里面放东西,此时肯定出问题
		while(lists.size() == MAX) { //想想为什么用while而不是用if？
			try {
				this.wait(); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		lists.add(t);
		++count;
		// 为什么使用notifyAll()而不使用notify()?
        // 因为notify()只是唤醒一个线程,如果下次唤醒的还是put线程,就会出现问题
		this.notifyAll(); //通知消费者线程进行消费
	}
	
	public synchronized T get() {
		T t = null;
		while(lists.size() == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		t = lists.removeFirst();
		count --;
		this.notifyAll(); //通知生产者进行生产
		return t;
	}
	
	public static void main(String[] args) {
		MyContainer1<String> c = new MyContainer1<>();
		//启动消费者线程
		for(int i=0; i<10; i++) {
			new Thread(()->{
				for(int j=0; j<5; j++) System.out.println(c.get());
			}, "c" + i).start();
		}
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//启动生产者线程
		for(int i=0; i<2; i++) {
			new Thread(()->{
				for(int j=0; j<25; j++) c.put(Thread.currentThread().getName() + " " + j);
			}, "p" + i).start();
		}
	}
}
