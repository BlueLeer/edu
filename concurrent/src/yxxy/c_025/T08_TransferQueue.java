package yxxy.c_025;

import java.util.concurrent.LinkedTransferQueue;

public class T08_TransferQueue {
	public static void main(String[] args) throws InterruptedException {
		LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();
		
		/*new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();*/
		
		//strs.transfer("aaa"); 阻塞式的,该消息会看有没有消费者,如果有消费者就直接将消息丢给消费者,否则,在这里就会阻塞

		strs.put("aaa");
		

		new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		// 上述代码,如果先启动生产者(调用transfer方法),后启动消费者,则消费者永远也执行不到
	}
}
