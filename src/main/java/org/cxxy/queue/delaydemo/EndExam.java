package org.cxxy.queue.delaydemo;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;

/**
 * 模拟考试，时间为120分钟，学生可以再30分钟后交卷， 当学生都交完了 或 时间到者考试结束
 * 
 * @author liuhui
 *
 */
public class EndExam extends Student {

	private DelayQueue<Student> students;
	private CountDownLatch countDownLatch;
	private Thread teacherThread;

	public EndExam(DelayQueue<Student> students, long workTime, CountDownLatch countDownLatch, Thread teacherThread) {

		super("强制收卷", workTime, countDownLatch);
		this.students = students;
		this.countDownLatch = countDownLatch;
		this.teacherThread = teacherThread;
	}

	@Override
	public void run() {

		teacherThread.interrupt();
		Student tmpStudent;
		
		// iterator()返回在此队列所有元素（既包括到期的，也包括未到期的）上进行迭代的迭代器。
		for (Iterator<Student> iterator2 = students.iterator(); iterator2.hasNext();) {

			tmpStudent = iterator2.next();
			tmpStudent.setForce(true);
			tmpStudent.run();
		}
		countDownLatch.countDown();
	}
}
