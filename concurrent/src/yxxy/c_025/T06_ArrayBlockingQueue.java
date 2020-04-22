package yxxy.c_025;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class T06_ArrayBlockingQueue {
    // 底层使用了数组作为基础的数据局结构支持,当队列满了以后不能支持容量扩展
    // ArrayBlockingQueue,此构造方法是构造一个公平的有界阻塞队列,等待时间长的线程会优先获取访问该队列的权利
	// static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10,true);
	static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);

	static Random r = new Random();

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			strs.put("a" + i);
		}
		
		strs.put("aaa"); //满了就会等待，程序阻塞,不继续往下执行了
		//strs.add("aaa"); //满了后再往里面加会报异常
		//strs.offer("aaa");//满了后再往里面加会加不进去
		//strs.offer("aaa", 1, TimeUnit.SECONDS);//满了后往里面加会等待最多1秒钟的时间,超过这个时间就不再往里面加了
		
		System.out.println(strs);
	}
}
