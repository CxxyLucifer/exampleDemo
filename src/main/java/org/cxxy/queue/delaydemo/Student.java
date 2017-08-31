package org.cxxy.queue.delaydemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Student implements Runnable, Delayed {

	private String name;
	private long workTime;
	private long submitTime;
	private boolean isForce = false;
	private CountDownLatch countDownLatch;

	public Student() {
	};

	public Student(String name, long workTime, CountDownLatch countDownLatch) {
		this.name = name;
		this.workTime = workTime;
		this.submitTime = TimeUnit.NANOSECONDS.convert(workTime, TimeUnit.NANOSECONDS) + System.nanoTime();
		this.countDownLatch = countDownLatch;
	}

	/**
	 * 将此对象与指定的对象进行比较以进行排序 比较此对象与指定对象的顺序。(如果该对象小于、等于或大于指定对象，则分别返回负整数、零或正整数)
	 */
	@Override
	public int compareTo(Delayed delayed) {

		Student s = (Student) delayed;

		if (this.workTime > s.workTime) {
			return 1;
		} else if (this.workTime == s.workTime) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(submitTime - System.nanoTime(), TimeUnit.NANOSECONDS);
	}

	@Override
	public void run() {

		if (isForce) {
			System.out.println(name + " 交卷, 希望用时" + workTime + "分钟" + " ,实际用时 120分钟,强行收卷");
		} else {
			System.out.println(name + " 交卷, 希望用时" + workTime + "分钟" + " ,实际用时 " + workTime + " 分钟");
		}
		countDownLatch.countDown();
	}

	public boolean isForce() {
		return isForce;
	}

	public void setForce(boolean isForce) {
		this.isForce = isForce;
	}

}
