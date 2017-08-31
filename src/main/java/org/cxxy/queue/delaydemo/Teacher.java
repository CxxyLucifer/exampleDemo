package org.cxxy.queue.delaydemo;

import java.util.concurrent.DelayQueue;

public class Teacher implements Runnable {

	private DelayQueue<Student> students;

	public Teacher(DelayQueue<Student> students) {
		this.students = students;
	}

	@Override
	public void run() {
		try {
			System.out.println(" test start");
			while (!Thread.interrupted()) {
				// offer方法: DelayQueue内部的实现使用了一个优先队列。当调用DelayQueue的offer方法时，把Delayed对象加入到优先队列q中。如下：
				// take方法: 获取并移除此队列的头部，在可从此队列获得到期延迟的元素之前一直等待
				students.take().run();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
