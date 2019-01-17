package org.cxxy.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:liuhui
 * Description:
 * Date: 4:12 PM 2018/11/29
 */
public class ReentrantLockDemo2 {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    private static Runnable runnable = () -> {
        try {
            if (reentrantLock.tryLock(3, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + "获取锁成功了");
                Thread.sleep(4000);
            } else {
                System.out.println(Thread.currentThread().getName() + "获取锁失败了");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (reentrantLock.isHeldByCurrentThread()) {
                System.out.println(Thread.currentThread().getName() + "释放锁了");
                reentrantLock.unlock();
            }
        }
    };


    public static void main(String[] args) {
        Thread thread1 = new Thread(runnable,"thread-1");
        Thread thread2 = new Thread(runnable,"thread-2");

        thread1.start();
        thread2.start();
    }
}
