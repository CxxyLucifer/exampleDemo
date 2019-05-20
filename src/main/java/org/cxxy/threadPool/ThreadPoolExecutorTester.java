package org.cxxy.threadPool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.*;


public class ThreadPoolExecutorTester {

    final static String THREAD_NAME = "threadPoolExecutorTester";

    static ThreadPoolExecutor pool;

    @PostConstruct
    public void init(){
        pool = new ThreadPoolExecutor(5, 10, 30, TimeUnit.MINUTES,
                new LinkedBlockingDeque<Runnable>(),
                new ThreadFactoryBuilder().setNameFormat(THREAD_NAME).build(),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public static void main(String[] args) {

        long time1 = System.currentTimeMillis();

        List<Future<HashMap<String, Object>>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            Future<HashMap<String, Object>> feature = pool.submit(new MyTask(i));

            futureList.add(feature);

            System.out.println("线程池中线程数目：" + pool.getPoolSize() + "，队列中等待执行的任务数目：" +
                    pool.getQueue().size() + "，已执行完的任务数目：" + pool.getCompletedTaskCount());
        }

        List<HashMap<String, Object>> result = new ArrayList<>();
        futureList.forEach(future -> {
            try {
                HashMap<String, Object> map = future.get();
                result.add(map);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        result.forEach(v -> {
            Iterator entries = v.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                if (entry.getKey() != null && entry.getValue() != null) {
                    String key = (String) entry.getKey();
                    Object value = entry.getValue();

                    System.out.println("key:" + key + " ,value:" + value);
                }
            }
        });


        long time2 = System.currentTimeMillis();

        System.out.println("cost time:" + (time2 - time1));

        pool.shutdown();
    }
}