package yxxy.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author WangLe
 * @date 2019/12/9 9:57
 * @description
 */
public class CasABA {
    public static void main(String[] args) {
        defectOfABA();
    }

    /**
     * 模拟CAS算法中可能出现的ABA问题
     * 问题描述:
     * 第一个线程取到了变量 x 的值 A，然后巴拉巴拉干别的事，总之就是只拿到了变量 x 的值 A。这段时间内第二个线程也取到了变量 x 的值 A，
     * 然后把变量 x 的值改为 B，然后巴拉巴拉干别的事，最后又把变量 x 的值变为 A （相当于还原了）。在这之后第一个线程终于进行了变量 x 的操作，
     * 但是此时变量 x 的值还是 A，所以 compareAndSet 操作是成功
     */
    private static void defectOfABA() {
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        // 该线程获取值以后,进行其他的任务处理,在处理其他的任务期间,另一个线程也获取了该值,并且修改了值最后又将值还原到原来的值了
        Thread coreThread = new Thread(() -> {
            int currentValue = atomicInteger.get();
            System.out.println(Thread.currentThread().getName() + " ------ currentValue=" + currentValue);

            // 模拟处理其他业务逻辑花费的时间,1秒
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 预期的值为1,当目前内存中的值和预期值一样的时候,就会将值设定为新的值
            boolean result = atomicInteger.compareAndSet(currentValue, 2);
            System.out.println(Thread.currentThread().getName()
                    + " ------ currentValue=" + currentValue
                    + ", finalValue=" + atomicInteger.get()
                    + ", compareAndSet Result=" + result);


        });
        coreThread.start();

        // 让主线程睡眠1秒钟,保证让coreThread先启动起来,并且运行起来
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // 该线程获取一个值以后,进行其他的逻辑处理,最后又将该值还原
        Thread otherThread = new Thread(() -> {
            int currentValue = atomicInteger.get();
            boolean casResult = atomicInteger.compareAndSet(currentValue, 2);
            System.out.println(Thread.currentThread().getName()
                    + " ------ currentValue=" + currentValue
                    + ", finalValue=" + atomicInteger.get()
                    + ", compareAndSet Result=" + casResult);

            currentValue = atomicInteger.get();
            casResult = atomicInteger.compareAndSet(currentValue, 1);
            System.out.println(Thread.currentThread().getName()
                    + " ------ currentValue=" + currentValue
                    + ", finalValue=" + atomicInteger.get()
                    + ", compareAndSet Result=" + casResult);
        });
        otherThread.start();
    }
}
