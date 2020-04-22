package yxxy.c_022;

import java.util.concurrent.*;

/**
 * @author WangLe
 * @date 2019/12/6 10:00
 * @description Executor框架结构主要有3大部分构成:
 * 1. 任务: Runnable/Callable
 * 2. 任务的执行,线程池,可以由Executors创建(不推荐),也可以有ThreadPoolExecutor来创建(推荐)
 * 3. 异步计算的结果,使用县城市的submit()方法提交的任务,会返回一个Future对象,该对象中包含了执行任务结束后的结果
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        test1();
//        test3();
    }
    public static void test1() {
        Runnable task = () -> {
            System.out.println("任务开始执行...");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务执行完毕...");
        };

        // 创建线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        // 将任务交给线程池进行执行
        poolExecutor.execute(task);
        // 关闭线程池,线程池的状态变为SHUTDOWN,线程池不再接受新的任务,但是队列里面的任务得执行完毕
        poolExecutor.shutdown();
        System.out.println("main执行完了...");
    }

    public static void test2() {
        Runnable task = () -> {
            System.out.println("任务开始执行...");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务执行完毕...");
        };

        // 创建线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        // 将任务交给线程池进行执行,返回的future中包含了任务执行返回的结果,因为这里task是Runnable对象,它没有返回值,所以future中包含的返回结果为null
        Future<?> future = poolExecutor.submit(task);
        try {
            Object o = future.get();
            System.out.println("任务执行完毕,返回执行结果: " + o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        poolExecutor.shutdown();

    }

    public static void test3() {
        Callable<String> task = () -> {
            System.out.println("任务开始执行...");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "任务执行完毕...";
        };

        // 创建线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        // 将任务交给线程池进行执行,返回的future中包含了任务执行返回的结果,因为这里task是Runnable对象,它没有返回值,所以future中包含的返回结果为null
        Future<String> future = poolExecutor.submit(task);
        try {
            // 阻塞式的,一直等到任务执行完毕,返回执行结果以后才会继续往下执行
            String result = future.get();
            System.out.println("任务执行完毕,返回执行结果: " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        poolExecutor.shutdown();

    }
}
