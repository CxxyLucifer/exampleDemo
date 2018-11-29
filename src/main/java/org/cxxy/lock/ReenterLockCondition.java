package org.cxxy.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:liuhui
 * Description:
 * Date: 4:56 PM 2018/11/29
 */
public class ReenterLockCondition {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    private static Condition condition = reentrantLock.newCondition();

    private static Runnable runnable = () -> {
        try {
            reentrantLock.lock();

            System.out.println(Thread.currentThread().getName() + "进入等待。。。");

            condition.await();

            System.out.println(Thread.currentThread().getName() + "继续执行");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(runnable,"thread-1");
        thread.start();

        Thread.sleep(2000);

        reentrantLock.lock();
        condition.signal();
        System.out.println("主线程发出信号");
        reentrantLock.unlock();
    }
}
