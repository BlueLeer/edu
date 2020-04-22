package yxxy.aqs;

import java.util.concurrent.Semaphore;

/**
 * @author lee
 * @date 2020/1/17 15:50
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }
}
