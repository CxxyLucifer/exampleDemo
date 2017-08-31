package org.cxxy.queue.cachedemo;

import java.util.Random;

public class main {

	public static void main(String[] args) throws Exception {

		Random random = new Random();

		int cacheNumber = 10;

		int liveTime = 0;

		Cache<String, Integer> cache = new Cache<String, Integer>();

		for (int i = 0; i < cacheNumber; i++) {

			liveTime = random.nextInt(3000);

			System.out.println("cache" + i + "  delaytime:" + liveTime);

			cache.put("cache" + i, i, random.nextInt(liveTime));
		}

		Thread.sleep(3000);

		System.out.println();
	}

}
