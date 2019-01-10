package org.cxxy.threadPool;

import java.util.HashMap;
import java.util.concurrent.Callable;

public class MyTask implements Callable {

    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public HashMap<String, Object> call() {
        System.out.println("正在执行task " + taskNum);
        HashMap<String, Object> result = new HashMap<String, Object>();
        try {
            Thread.currentThread().sleep(1000);
            result.put("task" + taskNum, taskNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + "执行完毕");

        return result;
    }
}
