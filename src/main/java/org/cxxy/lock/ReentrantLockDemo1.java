package org.cxxy.lock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * Author:liuhui
 * Description:
 * Date: 3:54 PM 2018/11/29
 */
public class ReentrantLockDemo1 {
    private static ReentrantLock lock = new ReentrantLock();

    private static int i = 0;

    private static Runnable runnable = () -> IntStream.range(0, 1000000).forEach((j) -> {
        lock.lock();
        try {
            i++;
        } finally {
            lock.unlock();
        }

    });


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("========i:" + i);
    }
}
