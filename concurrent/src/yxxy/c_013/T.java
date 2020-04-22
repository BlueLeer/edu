/**
 * volatile并不能保证多个线程共同修改running变量时所带来的不一致问题，也就是说volatile不能替代synchronized
 * 运行下面的程序，并分析结果
 *
 * @author mashibing
 */
package yxxy.c_013;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T {
    volatile int count = 0;

    void m() {
        for (int i = 0; i < 10000; i++) count++;
    }

    public static void main(String[] args) {
        T t = new T();

        List<Thread> threads = new ArrayList<Thread>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }

        threads.forEach((o) -> o.start());

        threads.forEach((o) -> {
            try {
                // 让创建的线程依次优先执行,等到这些线程都执行完了,才会执行主线程(main线程)
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
        // 主线程睡眠10秒钟,为了保证主线程已经执行完了
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.count);
    }

}


