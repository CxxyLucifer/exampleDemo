package org.cxxy.func.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Author:liuhui
 * Description:
 * Date: 9:18 AM 2018/12/20
 */
public class parallelTester {
    public static void main(String[] args) {
        long[] arrayOfLong = new long[20000];

        Arrays.parallelSetAll(arrayOfLong,index-> ThreadLocalRandom.current().nextInt(1000000));

        Arrays.stream(arrayOfLong).limit(10).forEach(i-> System.out.print(i + " "));
        System.out.println();

        Arrays.parallelSort(arrayOfLong);
        Arrays.stream(arrayOfLong).limit(10).forEach(i-> System.out.print(i + " "));
    }
}
