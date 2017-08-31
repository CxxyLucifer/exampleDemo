package org.cxxy.queue.cachedemo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;

/**
 * 业务场景二：具有过期时间的缓存
 * 
 * 该场景来自于http://www.cnblogs.com/jobs/archive/2007/04/27/730255.html，向缓存添加内容时，给每一个key设定过期时间，系统自动将超过过期时间的key清除。
 * 
 * 这个场景中几个点需要注意：
 * 
 * 当向缓存中添加key-value对时，如果这个key在缓存中存在并且还没有过期，需要用这个key对应的新过期时间 为了能够让DelayQueue将其已保存的key删除， 需要重写实现Delayed接口添加到DelayQueue的DelayedItem的hashCode函数和equals函数 当缓存关闭，监控程序也应关闭，因而监控线程应当用守护线程
 * 
 * @param <K>
 * @param <V>
 */
public class Cache<K, V> {

	// 并发编程实践中，ConcurrentHashMap是一个经常被使用的数据结构
	// ConcurrentHashMap在线程安全的基础上提供了更好的写并发能力，但同时降低了对读一致性的要求
	public ConcurrentHashMap<K, V> map = new ConcurrentHashMap<K, V>();

	public DelayQueue<DelayedItem<K>> queue = new DelayQueue<DelayedItem<K>>();

	public void put(K k, V v, long liveTime) {

		V v2 = map.put(k, v);

		DelayedItem<K> tmpItem = new DelayedItem<K>(k, liveTime);

		if (v2 != null) {

			queue.remove(tmpItem);
		}
		queue.put(tmpItem);
	}

	public Cache() {

		Thread t = new Thread() {

			@Override
			public void run() {

				dameonCheckOverdueKey();

			}
		};
		t.setDaemon(true);// 将该线程标记为守护线程
		t.start();
	}

	public void dameonCheckOverdueKey() {

		while (true) {
			if (queue.size() > 0) {

				// poll() 获取并移除此队列的头，如果此队列不包含具有已到期延迟时间的元素，则返回 null。
				DelayedItem<K> delayedItem = queue.poll();

				if (delayedItem != null) {

					map.remove(delayedItem.getT());

					System.out.println(System.nanoTime() + " remove " + delayedItem.getT() + " from cache");
				}
				try {

					Thread.sleep(300);

				} catch (Exception e) {

				}
			}
		}
	}

}
