package org.cxxy.threadPool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;


public class ThreadPoolExecutorTester {

    final static String THREAD_NAME = "threadPoolExecutorTester";

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 30, TimeUnit.MINUTES,
                new LinkedBlockingDeque<Runnable>(),
                new ThreadFactoryBuilder().setNameFormat(THREAD_NAME).build(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        long time1 = System.currentTimeMillis();


        List<Future<HashMap<String, Object>>> futureList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {

            Future<HashMap<String, Object>> feature = pool.submit(new MyTask(i));

            futureList.add(feature);

            System.out.println("线程池中线程数目：" + pool.getPoolSize() + "，队列中等待执行的任务数目：" +
                    pool.getQueue().size() + "，已执行完的任务数目：" + pool.getCompletedTaskCount());
        }

        List<HashMap<String, Object>> result = new ArrayList<>();
        for(Future future:futureList){
            try {
                HashMap<String, Object> map = (HashMap<String, Object>)future.get(6,TimeUnit.SECONDS);
                result.add(map);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }

        pool.shutdown();

        long time2 = System.currentTimeMillis();

        System.out.println("cost time:" + (time2 - time1));
    }
}


class MyTask implements Callable<HashMap<String, Object>> {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public HashMap<String, Object> call() {
        System.out.println("正在执行task " + taskNum);
        HashMap<String, Object> result = new HashMap<String, Object>();
        try {
            Thread.currentThread().sleep(1000 * taskNum);
            result.put("task" + taskNum, taskNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + "执行完毕");

        return result;
    }
}