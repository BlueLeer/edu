package yxxy.c_025;

import java.util.Calendar;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author WangLe
 * @date 2019/11/21 14:32
 * @description
 */
public class QueueTest {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<MyTask> queue = new DelayQueue<>();
        long now = System.currentTimeMillis();
        queue.add(new MyTask(1000 + now));
        queue.add(new MyTask(2000 + now));
        queue.add(new MyTask(3000 + now));

        for (int i = 0; i < 3; i++) {
            MyTask take = queue.take();
            take.printTime();
        }

    }

    static class MyTask implements Delayed {
        private long runningTime;

        public MyTask(long runningTime) {
            this.runningTime = runningTime;
        }

        public void printTime() {
            System.out.println(Calendar.getInstance().get(Calendar.SECOND));
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runningTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS))
                return -1;
            else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS))
                return 1;
            else
                return 0;
        }
    }
}
