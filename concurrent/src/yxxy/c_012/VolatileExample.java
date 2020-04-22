package yxxy.c_012;

import java.util.concurrent.TimeUnit;

/**
 * @author WangLe
 * @date 2019/12/9 10:36
 * @description 该类是使用volatile关键字的一个范例,规则:一写多读
 */
public class VolatileExample {


    private volatile int count = 0;

    /**
     * 写方法加锁,保证每次只有一个线程能够对共享变量进行写操作
     *
     */
    public synchronized void countAdd() {
       count++;
    }

    /**
     * 写方法加锁,保证每次只有一个线程能够对共享变量进行写操作
     */
    public synchronized void countReduce() {
        count--;
    }

    /**
     * 读方法不用加锁,因为使用volatile修饰以后的变量,是可以保证可见性的,写方法更新变量以后,读方法可以立马感知到
     * 多读
     *
     * @return
     */
    public int getCount() {
        return this.count;
    }

    public static void main(String[] args) {
        VolatileExample volatileExample = new VolatileExample();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                volatileExample.countAdd();
            }).start();
        }

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                volatileExample.countReduce();
            }).start();
        }


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count: " + volatileExample.getCount());
    }
}
