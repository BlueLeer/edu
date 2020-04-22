package yxxy.c_022;

import java.util.concurrent.*;

/**
 * @author WangLe
 * @date 2019/12/6 13:53
 * @description
 */
public class ScheduledThreadPoolExcutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();
    }

    private static void test1() throws ExecutionException, InterruptedException {
        Callable<String> task1 = () -> {
            int sleepSec = 1;
            TimeUnit.SECONDS.sleep(sleepSec);
            return "task1执行任务所花的时间为: " + sleepSec;
        };
        Callable<String> task2 = () -> {
            int sleepSec = 2;
            TimeUnit.SECONDS.sleep(sleepSec);
            return "task1执行任务所花的时间为: " + sleepSec;
        };

        Callable<String> task3 = () -> {
            int sleepSec = 3;
            TimeUnit.SECONDS.sleep(sleepSec);
            return "task1执行任务所花的时间为: " + sleepSec;
        };

        Callable<String> task4 = () -> {
            int sleepSec = 4;
            TimeUnit.SECONDS.sleep(sleepSec);
            return "task1执行任务所花的时间为: " + sleepSec;
        };


        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
        ScheduledFuture<String> schedule = threadPool.schedule(task1, 0, TimeUnit.SECONDS);
        ScheduledFuture<String> schedule1 = threadPool.schedule(task2, 0, TimeUnit.SECONDS);
        ScheduledFuture<String> schedule2 = threadPool.schedule(task3, 0, TimeUnit.SECONDS);
        ScheduledFuture<String> schedule3 = threadPool.schedule(task4, 0, TimeUnit.SECONDS);
        String s = schedule.get();
        String s1 = schedule1.get();
        String s2 = schedule2.get();
        String s3 = schedule3.get();
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }
}
