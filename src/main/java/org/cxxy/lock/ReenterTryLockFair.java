package org.cxxy.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:liuhui
 * Description:
 * Date: 4:29 PM 2018/11/29
 */
public class ReenterTryLockFair {

    private static ReentrantLock fairLock = new ReentrantLock(true);

    private static Runnable runnable = () -> {
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + " =获取了锁");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                fairLock.unlock();
                System.out.println(Thread.currentThread().getName() + " -释放了锁");
            }
    };


    public static void main(String[] args) {
        Thread thread1 = new Thread(runnable,"thread-1");
        Thread thread2 = new Thread(runnable,"thread-2");
        Thread thread3 = new Thread(runnable,"thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
