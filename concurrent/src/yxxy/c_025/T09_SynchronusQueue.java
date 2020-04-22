package yxxy.c_025;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class T09_SynchronusQueue { //容量为0
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> strs = new SynchronousQueue<>();
		
		new Thread(()->{
			try {
                TimeUnit.SECONDS.sleep(10);
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
		strs.put("aaa"); //阻塞等待消费者消费,也就是说没有容量,只要有一个元素,都得必须等到被消费了以后才能继续往下运行
		//strs.add("aaa");
		System.out.println(strs.size());
	}
}
