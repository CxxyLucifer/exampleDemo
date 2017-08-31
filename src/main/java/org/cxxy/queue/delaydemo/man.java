package org.cxxy.queue.delaydemo;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;

public class man {

	public static void main(String[] args) throws Exception {

		int studentNumber = 20;

		// CountDownLatch，一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
		CountDownLatch countDownLatch = new CountDownLatch(studentNumber + 1);

		DelayQueue<Student> students = new DelayQueue<Student>();

		Random random = new Random();

		for (int i = 0; i < studentNumber; i++) {

			//System.out.println("student" + (i + 1) + ",worktime:" + (30 + random.nextInt(120)));

			students.offer(new Student("student" + (i + 1), 30 + random.nextInt(120), countDownLatch));
		}

		Thread teacherThread = new Thread(new Teacher(students));

		students.offer(new EndExam(students, 120, countDownLatch, teacherThread));

		teacherThread.start();

		countDownLatch.await();

		System.out.println(" 考试时间到，全部交卷！");
	}

}
