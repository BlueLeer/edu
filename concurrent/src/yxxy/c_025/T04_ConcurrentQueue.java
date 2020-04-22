package yxxy.c_025;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 队列Queue是线程安全的,一个是以ConcurrentLinkedQueue为代表的高性能队列，
 * 一个是以BlockingQueue接口为代表的阻塞队列，无论在那种都继承自Queue。
 */
public class T04_ConcurrentQueue {
	public static void main(String[] args) {
		Queue<String> strs = new ConcurrentLinkedQueue<>();
		
		for(int i=0; i<10; i++) {
			strs.offer("a" + i);  //add
		}
		
		System.out.println(strs);
		
		System.out.println(strs.size());
		
		System.out.println(strs.poll());
		System.out.println(strs.size());
		
		System.out.println(strs.peek());
		System.out.println(strs.size());
		
		//双端队列Deque
	}
}
